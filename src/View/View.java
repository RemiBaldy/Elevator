
package View;

public interface View {

    /**
     *
     * @param floor
     */
    public void setElevatorFloor(int floor);

    /**
     *
     * @param floor
     * @param sens 1 <=> Vers le haut .
     * 			   0 <=> Vers le bas .
     */
    public void setExternButtonOn(int floor, int sens);

    /**
     *
     * @param floor
     */
    public void setInternButtonOn(int floor);

    /**
     *
     * @param floor
     * @param sens 1 <=> Vers le haut .
     * 			   0 <=> Vers le bas .
     */
    public void setExternButtonOff(int floor, int sens);

    /**
     *
     * @param floor
     */
    public void setInternButtonOff(int floor);

}

