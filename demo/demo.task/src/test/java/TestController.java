public class TestController {


    public static  void main(String[] args){

        Parent person = new Parent();
        person.work();
        person = (Son) person;
        person.work();

    }

}


class Parent{

    protected void work(){
        System.out.println("搬砖");
    }
}

class Son extends Parent{
    protected  void work(){
        System.out.println("上学");
    }
}
