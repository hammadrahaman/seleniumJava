package test.java;
import com.github.javafaker.Faker;
public class Fake {
    private static final Faker faker = new Faker();

    public static String fake(String f){
                switch (f.toLowerCase()){
                    case "email":
                        String email = faker.name().lastName()+ "@mailinator.com";
                        return email;
                    case "fullname":
                        String name = faker.name().fullName();
                        return name;
                    case "company":
                        String companyName = faker.company().name();
                        return companyName;
                    case "first name":
                        String firstName = faker.name().firstName();
                        return firstName;
                    case "last name":
                        String lastName = faker.name().lastName();
                        return  lastName;
                    case "dot":
                        int digit=5;
                        String dot= faker.number().digits(digit);
                        return dot;

                    case "zip":
                        String zip= faker.address().zipCode();
                        return zip;
                    case "city":
                        String city = faker.address().city();
                        return city;
                    case "address":
                        String address = faker.address().fullAddress();
                        return address;
                }
        return f;
    }

    public static void main(String[] args) {

        System.out.println(Fake.fake("address"));
        System.out.println();
    }
}



