fun main(args: Array<String>) {
    println("...............Hello welcome to kotlin class..................!")

    //println("Properties is: ${properties(12.5, 36.7)}")

    val fish = Fish();
    fish.makeSound();

    communication(
        message = {
            println("Hello from the deep sea.")
        },
        time = {
            10000L
        }
    )

    val cow = Mammal();
    cow crossBread fish
//anonymous with expression bodies
    val rand = listOf(90,-25,201,12,88,-2)
    val firstNegative = rand.find(fun(num) = num < 0)
    println("First negative value: $firstNegative")
//anonymous with block bodies
    val rand2 = listOf(90,-25,201,12,88,-2)
    val firstNegative2 = rand.find(fun(num): Boolean { return num < 0})
    println("First negative value: $firstNegative2")

    println("The FACTORIAL of 5! = ${factorial(5)}")
    println("The FACTORIALLOOP of 5! = ${factorialLoop(5)}")

    printer(20)


}
//fun properties(length: Double, width: Double): Pair<Double, Double>{
//    fun area(): Double = length * width;
//    fun perimeter(): Double = 2 * (length + width);
//    return Pair(area(),perimeter());
//}
//fun maxSum(a: Int?, b:Int?):Int{
//    fun isValid(): Boolean = a != null && b != null;
//    val new = if (isValid()) Int.MAX_VALUE else 0;
//    return  new;
//}


abstract class Animal(private val name: String){
    //properties
    abstract val limbs: Int
    abstract val isColdBlooded: Boolean
    abstract val sound: String?
    abstract val gestation: Double

    //behaviour
    open fun makeSound(){
        //local func
        fun customSound(): String{
            return if (sound.isNullOrBlank()){
                "The $name does not make sound"
            } else{
                "The $name is $sound"
            }
        }
        println(customSound())
    }

    open fun move(direction: String){
        println(
            """
                My $name is heading towards the $direction
            """.trimIndent()
        )
    }

    infix fun crossBread(breed: Animal){
        fun result(): Double {
            return if(breed.name.lowercase() == name.lowercase()){
                breed.gestation
            } else{
                return breed.gestation + gestation
            }
        }
        println("""
            The ${breed.name} and $name will yield an offspring after ${result()} months!! duration.
        """.trimIndent())

    }
}

class Fish() : Animal("fish")
{
    override val limbs: Int = 0
    override val isColdBlooded: Boolean = false
    override val sound: String? = null
    override val gestation: Double = 3.0
}

class Mammal : Animal("mammal"){
    override val limbs: Int = 4
    override val isColdBlooded: Boolean = false
    override val sound: String? = "Moo"
    override val gestation: Double = 9.0

}

inline fun communication(message:() -> Unit, noinline time:() -> Long){
    println("Incoming message ...");
    message();
    println("Message processed in ${time()} milliseconds")
}
//anonymous func
val calculate = fun(a:Int, b:Long):Long{
    return a+b;
}
//tail recursion
//getting factorial of a number
//3! = 3*2*1; 4! = 3!*4
fun factorial(n: Long): Long{
    if(n <= 1){
        return 1;
    } else {
       return n * factorial(n - 1)
    }
}
//re-write factorial to recursive func
/*
workings on compiler
factorial(4, 1)
factorial(3, 4)
factorial(2, 12)
factorial(1, 24)
 */
tailrec fun factorialWithTail(n: Long, total: Long): Long{
    val tmp = n * total;
    return if (n <= 1){
        tmp
    }else{
        factorialWithTail(n-1, tmp);
    }
}


fun factorialLoop(n:Long):Long{
    var sum: Long= 1L;
    var count =2;

    while (count <= n){
        sum  *= count;
        count++;
    }
    return sum;
}

//tail recursive func
fun printer(n: Int){
    if (n<0){
        return
    }
    println("Number : $n")
    printer(n-1);
}

//unary operator
