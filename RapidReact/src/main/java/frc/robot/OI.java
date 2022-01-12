package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class OI {
    public XboxController xbox = new XboxController(Constants.XBOX);
    
    public OI(){ }

    public double getXboxLeftX(){
        return xbox.getLeftX();
    }
    public double getXboxLeftY(){
        return xbox.getLeftY());
    }
    public double getXboxRightX(){
        return xbox.getRightX();
    }
    public double getXboxRightY(){
        return xbox.getRightY();
    
}
