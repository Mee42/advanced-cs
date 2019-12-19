

import java.util.*;

/**
 * Carson Graham
 */
class PrintQueue {
    private static int jobNumber = 100;

    static Queue<String> q = new ArrayDeque<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String prompt = "Add, Print, Delete, eXit:  ";
        System.out.print(prompt);
        String str = in.nextLine();
        while(!str.equals("X")) {
            switch (str) {
                case "A":
                    add();
                    break;
                case "P":
                    printJob();
                    break;
                case "D":
                    System.out.print("Number to delete:");
                    in.nextLine();
                    delete(in.nextLine());
                    break;
                default:
                    System.out.println("   invalid command");
                    break;
            }
            printQueue();
            System.out.print(prompt);
            str = in.next();
        }
        in.close();
    }

    public static void add() {
        q.add("" + jobNumber++);
    }
    public static void printJob() {
        System.out.println(q.remove());
    }

    public static void delete(String job) {
        if(!q.removeIf(i -> i.equals(job))){
            System.err.println("Can't find job " + job);
        }
    }
    public static void printQueue() {
        System.out.println(q);
    }
}
/*
example output:
/usr/lib/jvm/java-8-openjdk/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=38845:/opt/intellij-idea-ultimate-edition/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-openjdk/jre/lib/charsets.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/jce.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/jsse.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/resources.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/rt.jar:/home/carson/school/cs/build/production/cs PrintQueue
Add, Print, Delete, eXit:  A
[100]
Add, Print, Delete, eXit:  A
[100, 101]
Add, Print, Delete, eXit:  A
[100, 101, 102]
Add, Print, Delete, eXit:  A
[100, 101, 102, 103]
Add, Print, Delete, eXit:  P
100
[101, 102, 103]
Add, Print, Delete, eXit:  P
101
[102, 103]
Add, Print, Delete, eXit:  A
[102, 103, 104]
Add, Print, Delete, eXit:  A
[102, 103, 104, 105]
Add, Print, Delete, eXit:  D
Number to delete:106
[102, 103, 104, 105]
Can't find job 106
Add, Print, Delete, eXit:  104
   invalid command
[102, 103, 104, 105]
Add, Print, Delete, eXit:  D
Number to delete:104
[102, 103, 105]
Add, Print, Delete, eXit:  P
102
[103, 105]
Add, Print, Delete, eXit:  X

Process finished with exit code 0

 */