function Car(color, model, cost, fuelType) {
    this.color = color;
    this.model = model;
    this.cost = cost;
    this.fuelType = fuelType;
    let runningCostPerYear = 30000;

    this.getCarDetails = function(){
        console.log("Color : " + this.color);
        console.log("Model : " + this.model);
        console.log("Cost : " + this.cost);
        console.log("Fuel Type : " + this.fuelType);
        console.log("Running cost per year : " + this.runningCostPerYear);

    }

    this.totalCostOfOwnership = function(){
        console.log(this.runningCostPerYear = this.cost);
    }
}

let mercedes = new Car("Black", "C class", 5000000, "Petrol");
mercedes.getCarDetails();
mercedes.runningCostPerYear = 90000;
mercedes.totalCostOfOwnership();
