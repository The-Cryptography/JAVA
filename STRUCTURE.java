/*
* @filename
* @two line description about cipher
* code by author_name
* file should be saved with _cipher in last
* @Example XOR_cipher
*/

class swap
{
    /*One line about what function is doing*/
    
    static void swap(int a,int b)
    {
        int temp;
        temp=a;
        a=b;
        b=temp;

        System.out.println("Swapped numbers");
        System.out.println("a :"+a);
        System.out.println("b :"+b);
    }

    /*main*/
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();

        swap(a,b);//passing values to function

        sc.close();
    }
}
