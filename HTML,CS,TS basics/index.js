//Creating variables
var name = "Samiran" // Global variable
var age = 25;
var isGraduate = true;
var laptop;
laptop = "Asus"
console.log(name);

// creating function
function alertUser() {
    var favChips = "Cream and Onion"; // Local variable
    alert("This user is logged in " + name)
}
alertUser();
// console.log(favChips); // This will give error as we trying to get local variable

// if else statement
function operators(num) {
    if (num > 20) {
        console.log("Number is greater than 20");
    } else if (num == 20) {
        console.log("Number is equal to 20");
    } else {
        console.log("Number is smaller than 20");
    }
}

operators(89);

// Switch statement
function creditScore(score) {
    var creditLimit;
    switch (score) {
        case 800: creditLimit = "Above 1 lac";
            break;
        case 700: creditLimit = "50k to 1 lac";
            break;
        case 600: creditLimit = "Below 50k";
            break;
        default: creditLimit = "Not eligible";
    }
    console.log(creditLimit);
}
creditScore(800);

//For loop
function counting() {
    for (let i = 1; i <= 10; i++) {
        console.log(i);;
    }
}
counting();

// Creating objects
var car = new Object();
car.brand = "Tata";
car.model = "Nexon";
car.price = 1700000;
console.log(car);

//Creating array
var names = ["Sam", "Abhi", "Shiva"];
console.log(names);