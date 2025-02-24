package DataStructures.UseCase.stacks;

import java.util.Scanner;
import java.util.Stack;

public class UndoRedoTextEditor {
    private final Stack<String> currentText;
    private final Stack<String> undoStack;
    private String newText;

    public String getNewText() {
        return newText;
    }

    public UndoRedoTextEditor() {
        this.currentText = new Stack<>();
        this.undoStack = new Stack<>();
    }

    public String getCurrentText() {
        StringBuilder builder = new StringBuilder();
        for (String s : currentText) {
                builder.append(s).append(" ");
            }
        builder.append("\n");
        return builder.toString();
    }

    public void setNewText(String newText) {
        this.newText = newText;
        try {
            this.currentText.push(newText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void undoText() {
        if (newText != null) {
            newText = currentText.pop();
            undoStack.push(newText);
        }
    }

    public void redoText() {
        if (!undoStack.isEmpty()) {
            newText = undoStack.pop();
            currentText.push(newText);
        }
    }

    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor();

        boolean exit = false;
        while (!exit) {
            mainMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Enter text to add to Current text:\n");
                    String text = scanner.nextLine();
                    editor.setNewText(text);
                    System.out.println("Current Text\n" + editor.getCurrentText());
                    break;
                case 2:
                    editor.undoText();
                    System.out.printf("Text Removed: %s", editor.getNewText());
                    System.out.println("\n");
                    break;
                case 3:
                    editor.redoText();
                    System.out.printf("Text Re-added: %s", editor.getNewText());
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println(editor.getCurrentText());
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }

    }

    private static void mainMenu() {
        System.out.println("Welcome to the stack editor!\n\n"
                + "1. Add a new text to the stack\n"
                + "2. Undo the stack\n"
                + "3. Redo the stack\n"
                + "4. View Text\n"
                + "5. Exit");
    }

}
