public class Administrator  {
     public String id;
    public String adminName;
public String patients ;
public String data ;
public String providerId;
public String password;
    public Administrator(String id, String name, String contact) {
      this.id = id;
      this.adminName = adminName;
    }

    public void initSytem(){
        patients="";
        data="";
         providerId="";
        
    }
    
    public void Managemntaccount(){
        password="123456";
        adminName="yousef";
         
        
    }
    public void viewRecord(){
       System.out.print(data);
    }
    public void provideSecurityAccess(String p){
        if ( password==p){
            System.out.print("Access");
        } else{
            System.out.print("Denied");
            
        }
         
        
    }
    
    public void monitorSystem(){
        System.out.print("this is the data ");
       System.out.print(data);
       System.out.print("this is the patients ");
       System.out.print(patients);
    }
    
}
