

function maskEmail(email) {
  let indexOfDomain = email.indexOf("@");
  let domain = email.slice(indexOfDomain);
  return (
    email[0] +
    "*".repeat(indexOfDomain - 2) +
    email[indexOfDomain - 1] +
    domain
  );
}


function main() {
  let gmail = "apple.pie@example.com";
  console.log(maskEmail(gmail));
}

main();