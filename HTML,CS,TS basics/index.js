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

// Creating class

let Car = class {
    constructor(brand, modelName, price) {
        this.brand = brand;
        this.modelName = modelName;
        this.price = price;
    }

    print() {
        console.log("This is a " + this.brand + " " + this.modelName + ", which costs " + this.price);
    }
}

var car1 = new Car("Tata", "Nexon", 1700000);
car1.print();
var car2 = new Car("BMW", "3-series", "4000000") // we can use different datatypes
car2.print();

// Inheriting the methods of parent class
class TodaysDate extends Date {
    constructor() {
        super();
    }

    printDate() {
        console.log(this.getDate());
    }
}

let today = new TodaysDate();
today.printDate();

class AppleLaptops {
    constructor(brand) {
        this.brand = "Apple";
    }
}

class MackBookPro extends AppleLaptops {
    constructor(model, processor, ram) {
        super();
        this.model = model;
        this.processor = processor;
        this.ram = ram;
    }
}

let l1 = new MackBookPro("2021 15 Mackbook pro", "i7", 16);
console.log(l1.brand + " " + l1.model + " " + l1.processor + " " + l1.ram);

//Spread operator

let fruits = ["Apple", "Banana", "Pineapple"];
let seasonalFruits = ["Mango", "Lichi"];

let allFruits = [...fruits, ...seasonalFruits];
console.log(allFruits);

// arrow/inline function

let count = () => {
    for (let i = 1; i <= 10; i++) {
        console.log(i);;
    }
}

count();

// There are three way to declare variables in javascript

//var - this has block scope and it can be redefined, was announced with es6
var num1 = 1000;
var num1 = 2000;

//let - this has block scope and it can be redefined in same scope
let a = 100;
//let a = 200; // this will give error
function addNumbers() {
    let a = 230; // this will not give error
    let b = 200;
    console.log(a + b);
}

addNumbers();
console.log(a + 1000);

//const - Vale cannot be changed. This has block scope and it can be redefined

const c = 200;
//c= 500;  this will give an error

function dogs(){
    this.dogName = "Lab";
    throw new error("This is not a wild dog");
}

dogs.prototype.display = function () {
    return "this dogs breed is : " + this.dogName;
}

//constructor function
function Animal(dogName) {
    this.dogName = dogName;
}

//Create an object without using the constructor
Animal.prototype = Object.create(dogs.prototype);
let tommy = new Animal("German Shepherd");
console.log(tommy.display());
