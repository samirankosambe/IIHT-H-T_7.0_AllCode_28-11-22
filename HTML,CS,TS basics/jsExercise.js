class Employee {
    constructor() {
        this.companyName = "Cognizant"
    }
}

class Developer extends Employee {
    constructor(empName, exp, position, joiningDate, location, emailId, empId, salary) {
        super();
        this.empName = empName;
        this.exp = exp;
        this.dept = "Developer";
        this.position = position;
        this.joiningDate = joiningDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class HR extends Employee {
    constructor(empName, exp, position, joiningDate, location, emailId, empId, salary) {
        super();
        this.empName = empName;
        this.exp = exp;
        this.dept = "HR";
        this.position = position;
        this.joiningDate = joiningDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class Finance extends Employee {
    constructor(empName, exp, position, joiningDate, location, emailId, empId, salary) {
        super();
        this.empName = empName;
        this.exp = exp;
        this.dept = "Finance";
        this.position = position;
        this.joiningDate = joiningDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class Sales extends Employee {
    constructor(empName, exp, position, joiningDate, location, emailId, empId, salary) {
        super();
        this.empName = empName;
        this.exp = exp;
        this.dept = "Sales";
        this.position = position;
        this.joiningDate = joiningDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class Marketing extends Employee {
    constructor(empName, exp, position, joiningDate, location, emailId, empId, salary) {
        super();
        this.empName = empName;
        this.exp = exp;
        this.dept = "Marketing";
        this.position = position;
        this.joiningDate = joiningDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class QA extends Employee {
    constructor(empName, exp, position, joiningDate, location, emailId, empId, salary) {
        super();
        this.empName = empName;
        this.exp = exp;
        this.dept = "QA";
        this.position = position;
        this.joiningDate = joiningDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

var developer = new Developer("Sam", 2, "Programmer Analyst", "18-11-2022", "Pune", "abc@gmail.com", 123, 1200000);
console.log(developer.companyName + " " + developer.empName + " " + developer.exp + " " + developer.dept + " " + developer.position + " " +
    developer.joiningDate + " " + developer.location + " " + developer.emailId + " " + developer.empId + " " + developer.salary);

var hr = new HR("Sam", 2, "Manager", "18-11-2022", "Pune", "abc@gmail.com", 123, 1200000);
console.log(hr.companyName + " " + hr.empName + " " + hr.exp + " " + hr.dept + " " + hr.position + " " +
hr.joiningDate + " " + hr.location + " " + hr.emailId + " " + hr.empId + " " + hr.salary);

var finance = new Finance("Sam", 2, "Programmer Analyst", "18-11-2022", "Pune", "abc@gmail.com", 123, 1200000);
console.log(finance.companyName + " " + finance.empName + " " + finance.exp + " " + finance.dept + " " + finance.position + " " +
finance.joiningDate + " " + finance.location + " " + finance.emailId + " " + finance.empId + " " + finance.salary);

var sales = new Sales("Sam", 2, "Salesman", "18-11-2022", "Pune", "abc@gmail.com", 123, 1200000);
console.log(sales.companyName + " " + sales.empName + " " + sales.exp + " " + sales.dept + " " + sales.position + " " +
sales.joiningDate + " " + sales.location + " " + sales.emailId + " " + sales.empId + " " + sales.salary);

var marketing = new Marketing("Sam", 2, "BU head", "18-11-2022", "Pune", "abc@gmail.com", 123, 1200000);
console.log(marketing.companyName + " " + marketing.empName + " " + marketing.exp + " " + marketing.dept + " " + marketing.position + " " +
marketing.joiningDate + " " + marketing.location + " " + marketing.emailId + " " + marketing.empId + " " + marketing.salary);

var qa = new QA("Sam", 2, "Tester", "18-11-2022", "Pune", "abc@gmail.com", 123, 1200000);
console.log(qa.companyName + " " + qa.empName + " " + qa.exp + " " + qa.dept + " " + qa.position + " " +
qa.joiningDate + " " + qa.location + " " + qa.emailId + " " + qa.empId + " " + qa.salary);
