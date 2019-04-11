import com.figo.MainConfig;
import com.figo.MainConfigOfAOP;
import com.figo.aop.MathCaculator;
import com.figo.entity.JavaTeacher;
import com.figo.entity.Student;
import com.figo.entity.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SpringTest {
    @Test
    public void testGetBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Student student = (Student) context.getBean("student");
//        StudentController controller = (StudentController) context.getBean("sc");
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println(student);
    }

    @Test
    public void testOfAop() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCaculator mathCaculator = (MathCaculator) context.getBean("mathCaculator");
        mathCaculator.div(3, 1);
    }

    @Test
    public void testList() {
        ArrayList a = new ArrayList();
        System.out.println(a.get(1) + "===============" + a.size());
    }

    @Test
    public void testOfIO() {
    /*
     *this is a comment
     */
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            String fileName = "G:" + File.separator + "test.jpg";
            String newFileName = "G:" + File.separator + "test1.png";
            File file = new File(fileName);
            File newFile = new File(newFileName);
            in = new FileInputStream(file);
            if (newFile.exists()) {
                newFile.delete();
            }
            /*else{
                newFile.createNewFile();
            }*/
            out = new FileOutputStream(newFile);
            int temp = 0;
            byte[] b = new byte[1024];
            while ((temp = in.read()) != -1) {
                out.write(b, 0, 1);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        Teacher t = new JavaTeacher("1", "2");
        System.out.println(t.getIdno());
    }


    @Test
    public void sort1() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t=0;
        while(left<=right){
            arr[left++]=temp[t++];
        }

    }

    @Test
    public void sort2() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        qsort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void qsort(int[] arr,int left,int right){
        if(left<right) {
            int index = getIndex(arr, left, right);
            qsort(arr, left, index);
            qsort(arr, index + 1, right);
        }
    }
    public static int getIndex(int[] arr,int left,int right){
        int k=arr[left];
        while(left<right){
            int i=left;
            int j=right;
            while(arr[right]>k&&right>left){
                right--;
            }
                arr[left]=arr[right];
            while(arr[left]<k&&left<right){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=k;
        return left;
    }

}

