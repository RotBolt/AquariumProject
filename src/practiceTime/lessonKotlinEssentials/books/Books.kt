package practiceTime.lessonKotlinEssentials.books

import java.util.*


const val maxCapBorrow = 7
class BaseBook(val author:String,val title:String,val year:String,var pages:Int){

//    object Constants {
//        const val BASE_URL="https://www.deku-books.com"
//    }

    companion object {
        const val BASE_URL="https://www.deku-books.com"
    }

    fun canBorrow(hasBooks:Int) = hasBooks< maxCapBorrow
    fun printUrl() = println("$BASE_URL/$title.html")
    fun getBookAuthorNTitle() = author to title
    fun getBookDetails():Triple<String,String,String> = Triple(author,title,year)
}

fun BaseBook.weight()= pages*1.5
fun BaseBook.tornPages(tornPages:Int) = if (tornPages<pages)pages-=tornPages else pages=0


class Puppy(){
    fun playWithBooks(book: BaseBook){
        book.tornPages(Random().nextInt(12))
    }
}

fun main(args:Array<String>){
    val baseBook = BaseBook("Rohan Maity", "Legit Dhoke", "2018", 450)
    val (author,title,year) = baseBook.getBookDetails()
    println("""
        Author : $author,
        Title : $title,
        Year : $year

    """.trimIndent())
    val baseBook2 = BaseBook("Niharika", "Butter Chicken ke Sapne", "2018", 100)
    val (author2, title2) = baseBook2.getBookAuthorNTitle()
    println("""
        Author : $author2,
        Title : $title2,

    """.trimIndent())


    val allBooks = setOf("Hola","Poala","Hamlet","Pandas","Pui-Pui","Pika-Pika")
    val library = mapOf("Henda Books" to allBooks)

    val moreBooks = mutableMapOf("Rohan" to "Pika pika - pui pui")

    println(library)

    val isContained = library.any { it.value.contains("Hamlet") }
    println("Hamlet is there ? : $isContained")

    val pikaBook = moreBooks.getOrPut("Rohan"){"Hoi"}
    println("Pika Books : $pikaBook")

    val nihariBook = moreBooks.getOrPut("Niharika"){"Butter Chicken"}
    println("nihariBook Books : $nihariBook")


    baseBook.printUrl()


    val puppy = Puppy()

    while (baseBook.pages > 0) {
        puppy.playWithBooks(baseBook)
        println("${baseBook.pages} left in ${baseBook.title}")
    }
    println("Sad puppy, no more pages in ${baseBook.title}. ")
}