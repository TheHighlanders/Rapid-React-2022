package frc.robot;

//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;

public class OI {
    public XboxController xbox = new XboxController(Constants.XBOX);
    public XboxController xboxClimb = new XboxController(Constants.XBOXCLIMB);

    public Timer m_Timer;
    public boolean start = false;
    
    public OI(){
        m_Timer = new Timer();
        m_Timer.reset();
     }

    public double getXboxLeftX(){
        return xbox.getLeftX();
    }
    public double getXboxLeftY(){
        return xbox.getLeftY();
    }
    public double getXboxRightX(){
        return xbox.getRightX();
    }
    public double getXboxRightY(){
        return xbox.getRightY();
    }
    
    //xbox climbing

    public double getClimbXboxLeftX(){
        return xboxClimb.getLeftX();
    }
    public double getClimbXboxLeftY(){
        return xboxClimb.getLeftY();
    }
    public double getCLimbXboxRightX(){
        return xboxClimb.getRightX();
    }
    public double getClimbXboxRightY(){
        return xboxClimb.getRightY();
    }
    
    




    public void setxboxrumble(double vibrate, double length){
        if (m_Timer.get() > length || start == false) {
            start = true;
            m_Timer.reset();
            m_Timer.start();
            while (m_Timer.get() < length) {
                xbox.setRumble(RumbleType.kLeftRumble, vibrate);
                xbox.setRumble(RumbleType.kRightRumble, vibrate);
        }
        xbox.setRumble(RumbleType.kLeftRumble, 0);
        xbox.setRumble(RumbleType.kRightRumble, 0);
    }
    }
}
