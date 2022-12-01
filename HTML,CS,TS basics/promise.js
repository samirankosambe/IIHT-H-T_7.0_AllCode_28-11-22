const fun1 = () => {
    return "This is function 1";
}

const fun2 = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("This is function 2");
        }, 2000);
    });
};

const fun3 = () => {
    return "This is function 3";
}

const callFun = () => {
    let val1 = fun1();
    console.log(val1);
    let val2 = fun2();
    console.log(val2);
    let val3 = fun3();
    console.log(val3);
}