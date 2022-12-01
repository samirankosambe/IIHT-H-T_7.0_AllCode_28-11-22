const fun1 = () => {
    console.log("This is function 1");
}

const fun2 = () => {
    setTimeout(() => {
        console.log("Hey this function was executed in set timeout");
    }, 5000);
    console.log("This is function 2");
}

const fun3 = () => {
    console.log("This is function 3");
}

fun1();
fun2();
fun3();