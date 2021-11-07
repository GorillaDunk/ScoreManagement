package BookList;

public class BookDTO {

   private String book_id;
   private String book_name;
   private String writer;
   private String publisher;
   private String lev;
   
   public BookDTO(String book_id, String book_name, String writer, String publisher,String lev) {
      super();
      this.book_id = book_id;
      this.lev = lev;
      this.book_name = book_name;
      this.writer = writer;
      this.publisher = publisher;
   }
   
   public String getBook_id() {
      return book_id;
   }
   public void SetBook_id(String book_id) {
      this.book_id = book_id;
   }

   public String getLev() {
      return lev;
   }
   public void setLev(String lev) {
      this.lev = lev;
   }
   public String getBook_name() {
      return book_name;
   }
   public void setBook_name(String book_name) {
      this.book_name = book_name;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
   }
   public String getPublisher() {
      return publisher;
   }
   public void setPublisher(String publisher) {
      this.publisher = publisher;
   }
   
   
   
}