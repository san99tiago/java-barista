// LOAD-FILE (IMAGE) ERROR WITH EXCEPTION HANDLING
// Santiago Garcia Arango

package exceptions;

import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadFileError {

	// Attributes
	private static Image image;

	public static void main(String[] args) {
		// Run test with correct or incorrect path (must change true/false to see)
		test1(true); // true/false (to test)
	}

	public static void test1(boolean opensCorrectly) {
		// Add correct image-path if we want to show the error message
		String filePath;
		if (opensCorrectly) {
			filePath = "src/exceptions/ImageToTestException.png";
		} else {
			filePath = "ThisFileDoesntExist.png";
		}

		// We add try-catch to avoid errors when loading files
		try {
			image = ImageIO.read(new File(filePath));
			ImageIcon icon = new ImageIcon(image);
			JFrame frame = new JFrame();
			frame.setLayout(new FlowLayout());
			frame.setSize(820, 500);
			JLabel lbl = new JLabel();
			lbl.setIcon(icon);
			frame.add(lbl);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("Program added and loaded image correctly.");

		} catch (IOException e) {
			// This will run when an exception occurs in the "try" statement
			e.printStackTrace();
			System.out.println("Program did not find image.");
		}

	}
}
