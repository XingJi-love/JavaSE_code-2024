import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Win extends JFrame {
    private JTextField text;
    private JCheckBox checkBox1, checkBox2, checkBox3;
    private JRadioButton radio1, radio2;
    private ButtonGroup group;
    private JComboBox<String> comBox; // 使用泛型以避免类型转换
    private JTextArea area;
    private JPanel panel;
    private final String FILE_PATH = "D:\\code_JAVA\\students\\student.txt"; // 指定保存文件的路径

    public Win() {
        setTitle("信息收集表单");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 使用BoxLayout进行垂直布局

        panel.add(new JLabel("姓名："));
        text = new JTextField(10);
        panel.add(text);

        panel.add(new JLabel("爱好："));
        checkBox1 = new JCheckBox("喜欢音乐");
        checkBox2 = new JCheckBox("喜欢旅游");
        checkBox3 = new JCheckBox("喜欢篮球");
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);

        panel.add(new JLabel("性别："));
        radio1 = new JRadioButton("男");
        radio2 = new JRadioButton("女");
        group = new ButtonGroup(); // 实例化ButtonGroup
        group.add(radio1);
        group.add(radio2);
        panel.add(radio1);
        panel.add(radio2);

        panel.add(new JLabel("社团:"));
        comBox = new JComboBox<>(new String[]{"音乐天地", "武术天地", "象棋天地"}); // 直接初始化下拉框选项
        panel.add(comBox);

        panel.add(new JLabel("其他介绍："));
        area = new JTextArea(6, 12);
        panel.add(new JScrollPane(area));

        JButton button = new JButton("确定");
        panel.add(button);

        button.addActionListener(new ActionListener() { // 添加ActionListener
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = text.getText(); // 获取文本字段内容
                String sex = radio1.isSelected() ? "男" : "女";
                String community = (String) comBox.getSelectedItem();
                String intro = area.getText(); // 获取文本区域内容

                // 创建Student对象并尝试保存到文件
                Student student = new Student(name, sex, community, intro);
                try {
                    saveStudentToFile(student);
                    JOptionPane.showMessageDialog(panel, "信息已成功保存！", "成功", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "保存信息失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }

                clearFields(); // 清空输入字段
            }
        });

        add(panel);
        setVisible(true); // 设置窗口可见
    }

    private void saveStudentToFile(Student student) throws IOException {
        File file = new File(FILE_PATH);
        File dir = file.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")) {
            out.write(student.toString());
            out.write("\n"); // 换行
        }
    }

    private void clearFields() {
        text.setText("");
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        radio1.setSelected(true);
        radio2.setSelected(false);
        comBox.setSelectedIndex(0);
        area.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Win()); // 在事件调度线程中创建并显示GUI
    }
}