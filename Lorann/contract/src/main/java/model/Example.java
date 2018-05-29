package model;

/**
 * <h1>The Class Example.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class Example {


    /** The name of element */
    private String    element;
    
    /** The X coordinates of element */
    private int cooX;
    
    /** The Y coordinates of element */
    private int cooY;

    /**
     * Instantiates a new example.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     */
    public Example(final String element,final int cooX,final int cooY) {
        super();
        this.element = element;
        this.cooX = cooX;
        this.cooY = cooY;
    }

    /**
     * Gets the element.
     *
     * @return the element
     */
    public String getElement() {
        return this.element;
    }
    
        
    /**
     * Gets the X coordinates.
     *
     * @return the X coordinates
     */
    public int getCooX() {
        return this.cooX;
    }
    
    
    /**
     * Gets the Y coordinates.
     *
     * @return the Y coordinates
     */
    public int getCooY() {
        return this.cooY;
    }

    

    /**
     * Sets the element.
     *
     * @param element
     *            the new element
     */
    public void setElement(final String element) {
        this.element= element;
    }
    
    

    /**
     * Sets the X coordinates.
     *
     * @param element
     *            the new X coordinates
     */
    public void setCooX(final int cooX) {
        this.cooX= cooX;
    }
    
    
    /**
     * Sets the Y coordinates.
     *
     * @param element
     *            the new Y coordinates
     */
    public void setCooY(final int cooY) {
        this.cooY= cooY;
    }
    
    

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
   public String toString() {
        return this.getElement() + ";" + this.getCooX()+ ";" + this.getCooY();
    }
