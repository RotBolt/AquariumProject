package practiceTime.lessonOops

open class Book(private val author:String,private val title:String){
    private var pageCount = 0
    open fun readPage(){
        pageCount++
    }
}

class EBook(author: String,title:String,format:String="text"):Book(author,title){

    private var wordCount=0
    override fun readPage(){
        wordCount+=250
    }
}