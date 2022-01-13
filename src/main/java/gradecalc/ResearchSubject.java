package gradecalc;

/**
 * this is an interface that is implemented in the student class.
 */
public interface ResearchSubject {
   
    /**
     * sets boolean value if the student is participating in the research. 
     * @param isParticipating the choice if participating.
     */
    void setParticipating(boolean isParticipating);

    /**
     * contains the bonus mark from the research activities.
     * @return the research bonus mark.
     */
    double researchPerk();
    
}
