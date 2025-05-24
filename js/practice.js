let email = 'apple.pie@example.com';

function maskEmail(email){
  let indexOfDomain = email.indexOf("@");
  let domain = email[indexOfDomain,email.length];
  return email.index[0] + (indexOfDomain-2)*'*' + email[indexOfDomain-1] + domain
}

console.log(maskEmail(email))