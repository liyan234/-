public class Student implements Comparable<Student>{
        private String name;
        private int age;
        private String exam;

        public Student(String name,int age,String exam) {
            setName(name);
            setAge(age);
            setExam(exam);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getExam() {
            return exam;
        }

        public void setExam(String exam) {
            this.exam = exam;
        }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", exam='" + exam + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        //    return this.age - o.age;//从小到大排序
        return o.age - this.age;//从大到小排序
    }
}
