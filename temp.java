import java.util.ArrayList;
import javax.swing.*;


public class temp{
    public static void main(String[] args) {
        JFrame frame= new JFrame("Array Assignment");

        ArrayList<Integer> arrayList= new ArrayList<>();

        JLabel noOfElementsLabel= new JLabel("How many Elements: ");
        JTextField noOfElementsField= new JTextField();

        JLabel elementsLabel= new JLabel("Enter Elements: ");
        JTextField elementsField= new JTextField();

        JLabel indexLabel = new JLabel("Enter Index: ");
        JTextField indexField= new JTextField();

        JTextField displayResultField = new JTextField();
        displayResultField.setEditable(false);

        JButton addButton= new JButton("Add");
        JButton duplicateButton= new JButton("Duplicate");
        JButton updateButton= new JButton("Update");
        JButton deleteButton= new JButton("Delete");

        noOfElementsLabel.setBounds(50,50,154,30);
        noOfElementsField.setBounds(220,50,120,30);

        elementsLabel.setBounds(50,90,154,30);
        elementsField.setBounds(220,90,200,30);

        indexLabel.setBounds(50,130,100,30);
        indexField.setBounds(220,130,100,30);

        displayResultField.setBounds(50,180,370,30);

        addButton.setBounds(100, 230,80,30);
        duplicateButton.setBounds(180, 230,100,30);
        updateButton.setBounds(280, 230,80,30);
        deleteButton.setBounds(360, 230,80,30);

        frame.add(noOfElementsLabel);
        frame.add(noOfElementsField);
        frame.add(elementsLabel);
        frame.add(elementsField);
        frame.add(indexLabel);
        frame.add(indexField);
        frame.add(displayResultField);
        frame.add(addButton);
        frame.add(duplicateButton);
        frame.add(updateButton);
        frame.add(deleteButton);

        addButton.addActionListener(e->{
            String input= elementsField.getText();
            if(!input.isEmpty()){
                String[] parts= input.split(",");
                for(String p: parts){
                    try{
                        arrayList.add(Integer.parseInt(p.trim()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame, "Invalid number: "+p);
                    }
                }
            }
            displayResultField.setText(arrayList.toString());
            elementsField.setText("");
        });

        updateButton.addActionListener(e->{
            try{
                int index= Integer.parseInt(indexField.getText());
                int value= Integer.parseInt(elementsField.getText());
                if(index<0 || index>=arrayList.size()){
                    JOptionPane.showMessageDialog(frame, "Invalid Index!");
                }
                else{
                    arrayList.set(index, value);
                    displayResultField.setText(arrayList.toString());
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Enter valid numbers!");
            }
            indexField.setText("");
            elementsField.setText("");
        });

        deleteButton.addActionListener(e->{
            try{
                int index= Integer.parseInt(indexField.getText());
                if(index<0 || index>=arrayList.size()){
                    JOptionPane.showMessageDialog(frame, "Invalid Index!");
                }
                else{
                    arrayList.remove(index);
                    displayResultField.setText(arrayList.toString());
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Enter a valid index!");
            }
            indexField.setText("");
        });

        duplicateButton.addActionListener(e->{
            try{
                int index= Integer.parseInt(indexField.getText());
                if(index<0 || index>=arrayList.size()){
                    JOptionPane.showMessageDialog(frame, "Invalid Index!");
                    indexField.setText("");
                    return;
                }
                int value= arrayList.get(index);
                int count= 0;
                for(int num: arrayList){
                    if(num==value){
                        count++;
                    }
                }
                if(count>1){
                    JOptionPane.showMessageDialog(frame, value+" is duplicated. It appears "+count+" times.");

                    ArrayList<Integer> uniqueList= new ArrayList<>();
                    for(int num: arrayList){
                        if(!uniqueList.contains(num)){
                            uniqueList.add(num);
                        }
                    }
                    arrayList.clear();
                    arrayList.addAll(uniqueList);

                    displayResultField.setText(arrayList.toString());
                }
                else{
                    JOptionPane.showMessageDialog(frame, value+" is not duplicated.");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Enter a valid index!");
            }
            indexField.setText("");
        });

        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
