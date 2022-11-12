package com.lius.work.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lius.work.backend.exercise.ExerciseSheet;
import com.lius.work.backend.exercise.OperationTable;
import com.lius.work.backend.operation.ComponentUseOperationData;
import com.lius.work.backend.operation.OperationBase;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.util.List;

import javax.swing.ButtonGroup;

public class PracticeGui2 extends JFrame {
    private static final long serialVersionUID = -639767039479761232L;
    static final int WINDOW_WIDTH = 580; //���ڿ��
    static final int WINDOW_HEIGHT = 330;  //���ڸ߶�
    static final int OP_AMOUNT = 20;  //窗口内显示算式的总数量
    static final int OP_COLUMN = 5; // 算式的列数
    static final int OP_WIDTH = 65; // 算式的宽度
    static final int ANSWER_WIDTH = 35; // 答案的宽度
    static final int COMPONET_HEIGHT = 25; // 算式,答案的高度

    private JPanel contentPane;
    private JTextField[] tfOp;
    private JTextField[] tfAns;
    private JLabel labelStatus;
    private JLabel labelStat;
    private JLabel labelCurrent;
    private JLabel labelTotal;
    private JMenuItem mntmPre;
    private JMenuItem mntmNext;
    private JButton btnPre;
    private JButton btnNext;

    private ComponentUseOperationData<OperationBase> componentUseData;
    private int exerciseCount = 20;

    private int totalPages; // 总页数
    private int currentPage; // 当前处于多少页
    private boolean submitted; // 是否提交了答案

    private String operationType; // 题库使用的类型

    private final ButtonGroup buttonGroupTypes = new ButtonGroup();
    private final ButtonGroup buttonGroupAmount = new ButtonGroup();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PracticeGui2 frame = new PracticeGui2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 构造器
    public PracticeGui2() {
        setResizable(false);

        setTitle("\u53E3\u7B97\u7EC3\u4E60");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 234, 564, 2);
        contentPane.add(separator);

        //����Ϊ����Xҳ ��Xҳ����ǩ
        JLabel label_1 = new JLabel("\u7B2C");
        label_1.setBounds(196, 201, 23, 23);
        contentPane.add(label_1);
        labelCurrent = new JLabel("1");
        labelCurrent.setBounds(218, 201, 23, 23);
        contentPane.add(labelCurrent);
        JLabel label_2 = new JLabel("\u9875");
        label_2.setBounds(240, 201, 23, 23);
        contentPane.add(label_2);
        JLabel label_3 = new JLabel("\u5171");
        label_3.setBounds(270, 201, 23, 23);
        contentPane.add(label_3);
        labelTotal = new JLabel("3");
        labelTotal.setBounds(293, 201, 23, 23);
        contentPane.add(labelTotal);
        JLabel label_4 = new JLabel("\u9875");
        label_4.setBounds(316, 201, 23, 23);
        contentPane.add(label_4);

        labelStatus = new JLabel("\u72B6\u6001\uFF1A\u9898\u76EE\u7C7B\u578B-[\u4EC5\u52A0\u6CD5]  \u9898\u76EE\u6570\u91CF-[20]");
        labelStatus.setFont(new Font("����", Font.PLAIN, 12));
        labelStatus.setBounds(10, 243, 401, 25);
        contentPane.add(labelStatus);
        labelStat = new JLabel("\u7EDF\u8BA1\uFF1A\u6B63\u786E\u9898\u6570-[-] \u9519\u8BEF\u9898\u6570-[-] \u6B63\u786E\u7387-[-] \u9519\u8BEF\u7387-[-]");
        labelStat.setFont(new Font("����", Font.PLAIN, 12));
        labelStat.setBounds(10, 264, 520, 25);
        contentPane.add(labelStat);

        //����Ϊ�˵�
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 564, 25);
        contentPane.add(menuBar);
        JMenu menuFile = new JMenu("\u6587\u4EF6");
        menuBar.add(menuFile);
        JMenuItem mntnIn = new JMenuItem("\u5BFC\u5165\u9898\u76EE\u548C\u7B54\u6848");
        menuFile.add(mntnIn);
        JMenuItem mntmOut = new JMenuItem("\u5BFC\u51FA\u9898\u76EE\u548C\u7B54\u6848");
        menuFile.add(mntmOut);
        JMenu menuOption = new JMenu("\u9898\u76EE\u8BBE\u7F6E");
        menuBar.add(menuOption);
        JMenu mnTypes = new JMenu("\u6839\u636E\u7C7B\u578B\u751F\u6210");
        menuOption.add(mnTypes);
        JRadioButtonMenuItem rbtnAdd = new JRadioButtonMenuItem("\u52A0\u6CD5\u9898\u76EE");
        rbtnAdd.setSelected(true);
        buttonGroupTypes.add(rbtnAdd);
        mnTypes.add(rbtnAdd);
        JRadioButtonMenuItem rbtnSub = new JRadioButtonMenuItem("\u51CF\u6CD5\u9898\u76EE");
        buttonGroupTypes.add(rbtnSub);
        mnTypes.add(rbtnSub);
        JRadioButtonMenuItem rbtnBin = new JRadioButtonMenuItem("\u52A0\u51CF\u6DF7\u5408");
        buttonGroupTypes.add(rbtnBin);
        mnTypes.add(rbtnBin);
        JMenu mnAmount = new JMenu("\u6839\u636E\u6570\u91CF\u751F\u6210");
        menuOption.add(mnAmount);
        JRadioButtonMenuItem rbtnA20 = new JRadioButtonMenuItem("20");
        rbtnA20.setSelected(true);
        buttonGroupAmount.add(rbtnA20);
        mnAmount.add(rbtnA20);
        JRadioButtonMenuItem rbtnA40 = new JRadioButtonMenuItem("40");
        buttonGroupAmount.add(rbtnA40);
        mnAmount.add(rbtnA40);
        JRadioButtonMenuItem rbtnA60 = new JRadioButtonMenuItem("60");
        buttonGroupAmount.add(rbtnA60);
        mnAmount.add(rbtnA60);
        JRadioButtonMenuItem rbtnA80 = new JRadioButtonMenuItem("80");
        buttonGroupAmount.add(rbtnA80);
        mnAmount.add(rbtnA80);
        JRadioButtonMenuItem rbtnA100 = new JRadioButtonMenuItem("100");
        buttonGroupAmount.add(rbtnA100);
        mnAmount.add(rbtnA100);
        JMenu menuOpration = new JMenu("\u9898\u76EE\u64CD\u4F5C");
        menuBar.add(menuOpration);
        JMenuItem mntmGenerate = new JMenuItem("\u91CD\u65B0\u751F\u6210\u9898\u76EE\uFF08\u7C7B\u578B\u548C\u6570\u91CF\u4E0D\u53D8\uFF09");
        menuOpration.add(mntmGenerate);
        JMenuItem mntmClear = new JMenuItem("\u6E05\u7A7A\u7B54\u6848");
        menuOpration.add(mntmClear);
        JMenuItem mntmSubmit = new JMenuItem("\u63D0\u4EA4\u7B54\u6848");
        menuOpration.add(mntmSubmit);
        JMenu menuView = new JMenu("\u67E5\u770B");
        menuBar.add(menuView);
        mntmPre = new JMenuItem("\u4E0A\u4E00\u9875");
        menuView.add(mntmPre);
        mntmNext = new JMenuItem("\u4E0B\u4E00\u9875");
        menuView.add(mntmNext);

         // 为工具栏目
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 24, 564, 25);
        toolBar.setFloatable(false);
        contentPane.add(toolBar);
        JButton btnIn = new JButton("\u5BFC\u5165");
        toolBar.add(btnIn);
        JButton btnOut = new JButton("\u5BFC\u51FA");
        toolBar.add(btnOut);
        toolBar.addSeparator();
        JButton btnGenrate = new JButton("\u91CD\u65B0\u751F\u6210");
        toolBar.add(btnGenrate);
        JButton btnClear = new JButton("\u6E05\u7A7A");
        toolBar.add(btnClear);
        JButton btnSubmit = new JButton("\u63D0\u4EA4");
        toolBar.add(btnSubmit);
        toolBar.addSeparator();
        btnPre = new JButton("\u4E0A\u4E00\u9875");
        toolBar.add(btnPre);
        btnNext = new JButton("\u4E0B\u4E00\u9875");
        toolBar.add(btnNext);

        //导入题目和答案
        mntnIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("导入题目和答案");
                //impExercise();
            }
        });

        // 导出题目和答案
        mntmOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("导出题目和答案");
                //expExercise();
            }
        });
        // 加法题目
        rbtnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                System.out.println("加法题目" + exerciseCount);
                operationType = "加法";
                OperationTable<List<OperationBase>> listOperationTable = ExerciseSheet.generateOperationAddition(exerciseCount);
                List<OperationBase> data = listOperationTable.getData();
                componentUseData = new ComponentUseOperationData<OperationBase>(data);
                updateComponents();
            }
        });
        // 减法题目
        rbtnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                System.out.println("减法题目" + exerciseCount);
                operationType = "减法";
                OperationTable<List<OperationBase>> listOperationTable = ExerciseSheet.generateOperationSubtract(exerciseCount);
                List<OperationBase> data = listOperationTable.getData();
                componentUseData = new ComponentUseOperationData<OperationBase>(data);
                updateComponents();
            }
        });

        // 加减法混合
        rbtnBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                operationType = "加减法混合";
                OperationTable<List<OperationBase>> operationTableNumber = ExerciseSheet.getOperationTableNumber(ExerciseSheet.generateOperationBase(100), exerciseCount);
                componentUseData = new ComponentUseOperationData<>(operationTableNumber.getData());
                updateComponents();
            }
        });

        // 20个数量
        rbtnA20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                exerciseCount = 20;
                List<OperationBase> data = ExerciseSheet.generateOperationByTypeAndCount(operationType, exerciseCount).getData();
                componentUseData = new ComponentUseOperationData<>(data);
                updateComponents();
            }
        });

        // 40个数量
        rbtnA40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                exerciseCount = 40;
                List<OperationBase> data = ExerciseSheet.generateOperationByTypeAndCount(operationType, exerciseCount).getData();
                componentUseData = new ComponentUseOperationData<>(data);
                updateComponents();
            }
        });

        // 60 个题目
        rbtnA60.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                exerciseCount = 60;
                List<OperationBase> data = ExerciseSheet.generateOperationByTypeAndCount(operationType, exerciseCount).getData();
                componentUseData = new ComponentUseOperationData<>(data);
                updateComponents();
            }
        });

        // 80个题目
        rbtnA80.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                exerciseCount = 80;
                List<OperationBase> data = ExerciseSheet.generateOperationByTypeAndCount(operationType, exerciseCount).getData();
                componentUseData = new ComponentUseOperationData<>(data);
                updateComponents();
            }
        });

        // 100个题目
        rbtnA100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearComponentUseData();
                clearAnswers();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                exerciseCount = 100;
                List<OperationBase> data = ExerciseSheet.generateOperationByTypeAndCount(operationType, exerciseCount).getData();
                componentUseData = new ComponentUseOperationData<>(data);
                updateComponents();
            }
        });

        // 重新生成题目
        mntmGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("重新生成题目");
                clearAnswers();
                submitted = false;
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                clearComponentUseData();
                List<OperationBase> data = ExerciseSheet.generateOperationByTypeAndCount(operationType, exerciseCount).getData();
                componentUseData = new ComponentUseOperationData<>(data);
                updateComponents();
            }
        });

        // 清空答案
        mntmClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("清空答案");
                clearAnswers();
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                updateComponents();
            }
        });

        // 提交答案
        mntmSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("提交答案");
                currentPage = 1;
                judgeAnswer();
                mntmSubmit.setEnabled(false);
                btnSubmit.setEnabled(false);
            }
        });

        // 上一页
        mntmPre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("上一页");
                prePage();
            }
        });

        // 下一页
        mntmNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("下一页");
                nextPage();
            }
        });

       ;

        // 工具栏上的按钮动作
        btnIn.addActionListener(new ActionListener() {// 导入题目 按钮动作
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("导入题目");
                //impExercise();
            }
        });
        btnOut.addActionListener(new ActionListener() { // 导出题目 按钮动作
            public void actionPerformed(ActionEvent e) {
                System.out.println("导出题目");
                //expExercise();
            }
        });
        btnGenrate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { // 重新生成题目 按钮动作
                System.out.println("重新生成题目 按钮动作");
                clearAnswers();
                submitted = false;
                clearComponentUseData();
                List<OperationBase> data = ExerciseSheet.generateOperationByTypeAndCount(operationType, exerciseCount).getData();
                componentUseData = new ComponentUseOperationData<>(data);
                updateComponents();
            }
        });
        btnClear.addActionListener(new ActionListener() { // 清空答案
            public void actionPerformed(ActionEvent e) {
                System.out.println("清空答案");
                btnSubmit.setEnabled(true);
                mntmSubmit.setEnabled(true);
                clearAnswers();
                updateComponents();
            }
        });
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // 提交答案 按钮动作
                System.out.println("提交答案, 并且判断结果");
                currentPage = 1;
                judgeAnswer();
                mntmSubmit.setEnabled(false);
                btnSubmit.setEnabled(false);
            }
        });
        btnPre.addActionListener(new ActionListener() { // 上一页 按钮动作
            public void actionPerformed(ActionEvent e) {
                System.out.println("上一页");
                prePage();
            }
        });
        btnNext.addActionListener(new ActionListener() { // 下一页按钮动作
            public void actionPerformed(ActionEvent e) {
                System.out.println("下一页按钮动作");
                nextPage();
            }
        });

        initComponents();
        updateComponents();
    }

    // TODO: 导入文件
//	private void impExercise(){
//		JFileChooser jfc = new JFileChooser();
//		jfc.showOpenDialog(null);
//		File file=jfc.getSelectedFile();
//		try{
//
//
//            new OperationFileStream().readStream(,file.getAbsolutePath());
//			exercise = Exercise_3_2_ch7.loadObject();
//			JOptionPane.showMessageDialog(null, "������Ŀ�ɹ���",
//					"��ʾ",JOptionPane.INFORMATION_MESSAGE);
//			this.submitted = false;
//			updateComponets();
//		}catch(NullPointerException npe){
//            JOptionPane.showMessageDialog(null, "������Ŀʧ�ܣ���������Ϊѡ���˴�����ļ�",
//                    "����",JOptionPane.ERROR_MESSAGE);
//		}catch(ExerciseIOException e){
//			JOptionPane.showMessageDialog(null, "������Ŀʧ�ܣ���������Ϊѡ���˴�����ļ�",
//					"����",JOptionPane.ERROR_MESSAGE);
//		}
//	}

    // TODO: 导出
//    private void expExercise() {  //������Ŀ
//        JFileChooser jfc = new JFileChooser();
//        jfc.showSaveDialog(null);
//        File file = jfc.getSelectedFile();
//        try {
//            exercise.saveObject(file.getAbsolutePath());
//            JOptionPane.showMessageDialog(null, "������Ŀ�ɹ���",
//                    "��ʾ", JOptionPane.INFORMATION_MESSAGE);
//        } catch (NullPointerException npe) {
//
//        } catch (ExerciseIOException e) {
//            JOptionPane.showMessageDialog(null, "������Ŀʧ�ܣ���������Ϊ�����ļ�ʧ��",
//                    "����", JOptionPane.ERROR_MESSAGE);
//        }
//    }

//    	private void generateExercise(){ //����������Ŀ
//		int length = exercise.length();
//		exercise.generateWithFormerType(length);
//		updateComponets();
//	}

    private void judgeAnswer() { // 判断答案是否正确
        this.submitted = true;
        System.out.println("页数: " + this.currentPage + " 的答案");
        for(int i = 1; i < totalPages;i++){
            getAnswers(i); // 获取答案, 当前页数的
        }
        // getAnswers(this.currentPage); // 获取答案, 当前页数的
        updateComponents(); // 更新状态
    }

    private void prePage() { // 上一页
        if (this.currentPage == this.totalPages) this.leaveEnd();
        if (--currentPage == 1) this.reachBegin();
        this.labelCurrent.setText(String.valueOf(currentPage));
        updateComponents();
    }

    private void nextPage() { //下一页
        if (this.currentPage == 1) this.leaveBegin(); // 第一页
        if (++currentPage == this.totalPages) this.reachEnd(); //最后一页
        this.labelCurrent.setText(String.valueOf(currentPage));
        updateComponents();
    }

    // 获取题目的答案(当前页数)
    private void getAnswers(int pageIndex) {
        for (int i = 0; i < OP_AMOUNT; i++) {
            componentUseData.setAnswerJudge((pageIndex - 1) * OP_AMOUNT + i, tfAns[i].getText());
        }
    }


    private void clearAnswers() {
        // TODO: 清空答案, 此处并非使用exercise
        // exercise.clearAnswers();
        componentUseData.cleanAnswer();
        this.submitted = false;
        updateComponents();
    }

    /**
     * 在更新数据的时候
     * 1. 删除数据
     * 2. 移动到页码的第一页
     */
    private void clearComponentUseData() {
        this.currentPage = 1;
        componentUseData = null;
    }

    // 初始化组件
    private void initComponents() {
        System.out.println("初始化操作");
        this.submitted = false;
        this.operationType = "加法";

        OperationTable<List<OperationBase>> listOperationTable = ExerciseSheet.generateOperationAddition(exerciseCount);
        List<OperationBase> data = listOperationTable.getData();
        componentUseData = new ComponentUseOperationData<>(data);

        this.currentPage = 1;
        this.totalPages = 1;
        this.reachBegin();
        this.reachEnd();

        tfOp = new JTextField[OP_AMOUNT];
        tfAns = new JTextField[OP_AMOUNT];

        for (int i = 0; i < OP_AMOUNT; i++) {
            tfOp[i] = new JTextField();
            tfOp[i].setBounds(20 + (i % OP_COLUMN) * (OP_WIDTH + ANSWER_WIDTH + 5),
                    60 + (i / OP_COLUMN) * (COMPONET_HEIGHT + 10),
                    OP_WIDTH,
                    COMPONET_HEIGHT);
            tfOp[i].setHorizontalAlignment(JTextField.RIGHT);
            tfOp[i].setEditable(false);
            contentPane.add(tfOp[i]);

            tfAns[i] = new JTextField();
            tfAns[i].setBounds(20 + OP_WIDTH + (i % OP_COLUMN) * (OP_WIDTH + ANSWER_WIDTH + 5),
                    60 + (i / OP_COLUMN) * (COMPONET_HEIGHT + 10),
                    ANSWER_WIDTH,
                    COMPONET_HEIGHT);
            contentPane.add(tfAns[i]);
        }
    }

    private void reachBegin() {
        this.btnPre.setEnabled(false);
        this.mntmPre.setEnabled(false);
    }

    private void reachEnd() {
        this.btnNext.setEnabled(false);
        this.mntmNext.setEnabled(false);
    }

    private void leaveBegin() {
        this.btnPre.setEnabled(true);
        this.mntmPre.setEnabled(true);
    }

    private void leaveEnd() {
        this.btnNext.setEnabled(true);
        this.mntmNext.setEnabled(true);
    }

    // 更新组件
    private void updateComponents() {
        this.totalPages = exerciseCount / OP_AMOUNT; // 总页数
        this.labelCurrent.setText(String.valueOf(this.currentPage)); //  当前页码
        this.labelTotal.setText(String.valueOf(this.totalPages)); // 总页数

        //  判断是第一页还是最后一页
        if (this.currentPage == 1) this.reachBegin();
        else this.leaveBegin();
        if (this.currentPage == this.totalPages) this.reachEnd();
        else this.leaveEnd();

        OperationBase operationBase;
        for (int i = 0; i < OP_AMOUNT; i++) {
            operationBase = componentUseData.get((currentPage - 1) * OP_AMOUNT + i);

            tfOp[i].setText(operationBase.asString());

            if (!submitted) { // 是否提交
                tfAns[i].setBackground(Color.WHITE);
                tfAns[i].setText("");
            } else { // 判断答案
                if (componentUseData.getAnswerJudge((currentPage - 1) * OP_AMOUNT + i))
                    tfAns[i].setBackground(Color.GREEN);
                else
                    tfAns[i].setBackground(Color.RED);
                // 输出答案
                tfAns[i].setText(operationBase.getValue() + "");
            }

            labelStatus.setText("状态：题目类型-["
                    + operationType + "]  题目数量-[" + exerciseCount + "]");
            if (!submitted) {
                labelStat.setText("答题统计：点[提交答案]之后可获取");
            } else {
                int total = exerciseCount;
//                int correct = exercise.Correct(); // 正确的数量
                int correct = 10; // 正确的数量
                int wrong = total - correct;
                int cratio = (int) ((float) correct / total * 100);
                int wratio = 100 - cratio;
                String stat = "答题统计： 正确题数[" + correct
                        + "]  错误题数[" + wrong
                        + "]  正确率[" + cratio
                        + "%]  错误率[" + wratio + "%]";
                labelStat.setText(stat);
            }
        }
    }
}
