
Không thể biên dịch được là do kí tự \` là kí tự đặc biệt, cần có kí tự \\ đừng trước để có thể in ra.  
Cần sửa lại như sau :  
```java 
    public class Hello {
        public static void main() {
            System.out.println("Doesn\'t execute");
        }
    }
```
