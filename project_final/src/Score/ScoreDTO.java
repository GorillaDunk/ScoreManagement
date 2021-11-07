package Score;


   public class ScoreDTO {

      
      private String std_id;
      private String std_name;
      private String Ex_date;
      private String weekly_test;
      private String monthly_test;
      
      public ScoreDTO(String std_id, String std_name, String ex_date, String weekly_test, String monthly_test) {
         super();
         this.std_id = std_id;
         this.std_name = std_name;
         Ex_date = ex_date;
         this.weekly_test = weekly_test;
         this.monthly_test = monthly_test;
      }

      public String getStd_id() {
         return std_id;
      }

      public void setStd_id(String std_id) {
         this.std_id = std_id;
      }

      public String getStd_name() {
         return std_name;
      }

      public void setStd_name(String std_name) {
         this.std_name = std_name;
      }

      public String getEx_date() {
         return Ex_date;
      }

      public void setEx_date(String ex_date) {
         Ex_date = ex_date;
      }

      public String getWeekly_test() {
         return weekly_test;
      }

      public void setWeekly_test(String weekly_test) {
         this.weekly_test = weekly_test;
      }

      public String getMonthly_test() {
         return monthly_test;
      }

      public void setMonthly_test(String monthly_test) {
         this.monthly_test = monthly_test;
      }
   
   
      
   }
