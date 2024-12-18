import java.io.*;
import java.util.Scanner;

public class Picture {
    private String Description;
    private Integer Width;
    private Integer Height;
    private String FrameColour;

    public Picture(String Description, Integer Width, Integer Height, String FrameColour){
        this.Description = Description;
        this.Width = Width;
        this.Height = Height;
        this.FrameColour = FrameColour;
    }

    public String GetDescription(){
        return Description;
    }

    public Integer GetWidth(){
        return Width;
    }

    public Integer GetHeight(){
        return Height;
    }

    public String GetFrameColour(){
        return FrameColour;
    }

    public void SetDescription(String newDescription){
        Description = newDescription;
    }

    static Picture[] pictures = new Picture[100];

    public static Integer ReadData(){
        File file = new File("Pictures.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                pictures[i] = new Picture(null, null, null, null);
                pictures[i].Description = line;
                line = reader.readLine();
                pictures[i].Width = Integer.valueOf(line);
                line = reader.readLine();
                pictures[i].Height = Integer.valueOf(line);
                line = reader.readLine();
                pictures[i].FrameColour = line;
                i++;
            }
            for (int j = 0; j < 100; j++) {
                if (pictures[j] == null) {
                    return j;
                }
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static void main(String[] args){
        int elements = ReadData();
        System.out.println(elements);
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the colour of the frame: ");
        String frameColour = keyboard.next().toLowerCase();

        System.out.println("Enter the width of the picture: ");
        Integer width = keyboard.nextInt();

        System.out.println("Enter the height of the picture: ");
        Integer height = keyboard.nextInt();

        for (int i = 0; i <elements ; i++) {
            if(frameColour.equals(pictures[i].FrameColour)){
                System.out.println(pictures[i].Description);
                System.out.println(pictures[i].Width);
                System.out.println(pictures[i].Height);
            } else if (width.equals(pictures[i].Width)) {
                System.out.println(pictures[i].Description);
                System.out.println(pictures[i].Width);
                System.out.println(pictures[i].Height);
            }else if (height.equals(pictures[i].Height)) {
                System.out.println(pictures[i].Description);
                System.out.println(pictures[i].Width);
                System.out.println(pictures[i].Height);
            }
        }
    }
}
