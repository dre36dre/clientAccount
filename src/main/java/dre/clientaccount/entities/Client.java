import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entities
@Table(name="tb_client")
public class Client {
@id
@GeneratedValue(strategy=GenerationType.IDENTIFY)
 private Long id;
 private String name;
 private String email;

 @ManyToOne
 @JoinColumn(name="account_id")
 private Account account;

 public Client(){

 }

 public Long getId(){
    return this.id;
 }

 public void setId(Long id){
    this.id=id;
 }


 public String getName(){
    return this.name;
 }
 public void setName(String name){
    this.name=name;
 }

 public String getEmail(){
    return this.email;
 }

 public void setEmail(String email){
    this.email=email;
 }


}