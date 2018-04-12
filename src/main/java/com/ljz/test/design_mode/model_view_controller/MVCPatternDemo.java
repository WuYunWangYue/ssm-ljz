package com.ljz.test.design_mode.model_view_controller;

public class MVCPatternDemo {
    public static void main(String[] args) {

        //从数据可获取学生记录
        Student model = retrieveStudentFromDatabase();

        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        System.out.println("====================================");
        //更新模型数据
        controller.setStudentName("John");
        controller.setStudentRollNo("12");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}