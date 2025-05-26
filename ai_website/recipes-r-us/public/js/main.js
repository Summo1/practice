document.addEventListener('DOMContentLoaded', function() {
    const budgetForm = document.getElementById('budgetForm');
    const weeklyBudgetInput = document.getElementById('weeklyBudget');
    const budgetSection = document.querySelector('.budget-section');
    const currentPlanSection = document.querySelector('.current-plan-section');
    const displayBudget = document.getElementById('displayBudget');
    const remainingBudget = document.getElementById('remainingBudget');
    const mealPlanPreview = document.getElementById('mealPlanPreview');

    // Load saved data from localStorage
    const savedBudget = localStorage.getItem('weeklyBudget');
    const savedMealPlan = JSON.parse(localStorage.getItem('mealPlan')) || [];
    const savedCart = JSON.parse(localStorage.getItem('shoppingCart')) || [];

    if (savedBudget) {
        weeklyBudgetInput.value = savedBudget;
        displayBudget.textContent = `$${savedBudget}`;
        
        // Calculate remaining budget
        const totalCost = savedMealPlan.reduce((total, meal) => total + meal.cost, 0);
        const remaining = savedBudget - totalCost;
        remainingBudget.textContent = `$${remaining.toFixed(2)}`;
        
        // Display meal plan preview if there are meals
        if (savedMealPlan.length > 0) {
            renderMealPlanPreview(savedMealPlan);
            budgetSection.classList.add('hidden');
            currentPlanSection.classList.remove('hidden');
        }
    }

    // Handle budget form submission
    budgetForm.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const budget = parseFloat(weeklyBudgetInput.value);
        if (isNaN(budget) || budget <= 0) {
            alert('Please enter a valid budget amount.');
            return;
        }
        
        // Save to localStorage
        localStorage.setItem('weeklyBudget', budget);
        displayBudget.textContent = `$${budget.toFixed(2)}`;
        remainingBudget.textContent = `$${budget.toFixed(2)}`;
        
        // Clear any existing meal plan and cart when setting a new budget
        localStorage.removeItem('mealPlan');
        localStorage.removeItem('shoppingCart');
        mealPlanPreview.innerHTML = '<p>No meals selected yet.</p>';
        
        budgetSection.classList.add('hidden');
        currentPlanSection.classList.remove('hidden');
    });

    function renderMealPlanPreview(meals) {
        if (meals.length === 0) {
            mealPlanPreview.innerHTML = '<p>No meals selected yet.</p>';
            return;
        }
        
        // Group meals by day
        const mealsByDay = {};
        meals.forEach(meal => {
            if (!mealsByDay[meal.day]) {
                mealsByDay[meal.day] = [];
            }
            mealsByDay[meal.day].push(meal);
        });
        
        let html = '<div class="preview-grid">';
        
        // Create a preview for each day
        const days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
        days.forEach(day => {
            html += `<div class="preview-day">
                        <h3>${day}</h3>`;
            
            if (mealsByDay[day] && mealsByDay[day].length > 0) {
                mealsByDay[day].forEach(meal => {
                    html += `<div class="preview-meal">
                                <h4>${meal.name}</h4>
                                <p>$${meal.cost.toFixed(2)}</p>
                            </div>`;
                });
            } else {
                html += '<p class="no-meal">No meal selected</p>';
            }
            
            html += '</div>';
        });
        
        html += '</div>';
        mealPlanPreview.innerHTML = html;
    }
});