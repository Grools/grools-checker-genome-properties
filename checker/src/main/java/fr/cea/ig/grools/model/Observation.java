/*
 *
 * Copyright LABGeM 2015
 *
 * author: Jonathan MERCIER
 *
 * This software is a computer program whose purpose is to annotate a complete genome.
 *
 * This software is governed by the CeCILL  license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 *
 */

package fr.cea.ig.grools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.time.LocalDate;

/**
 * Observation
 */
/*
 * @startuml
 * skinparam shadowing false
 * skinparam defaultFontName courier
 * interface Observation<T extends State> extends Fact {
 *  + getTheoryId()         : String
 *  + getObservationType()         : ObservationType
 *  + getState()            : T
 *  + getIsExperimental()   : boolean
 *  + getIsAPrediction()    : boolean
 *  + getIsAnExpectation()  : boolean
 * }
 * @enduml
 */
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class Observation<T extends Term> extends Fact {
    protected final String          theoryId;
    protected final ObservationType observationType;
    protected final T               state;
    protected final boolean         isExperimental;
    protected final boolean         isAPrediction;
    protected final boolean         isAnExpectation;

    protected Observation(
            @NonNull final String id,
            @NonNull final String name,
            @NonNull final String source,
            @NonNull final LocalDate date,
            @NonNull final String theoryId,
            @NonNull final ObservationType observationType,
            @NonNull final T state,
                     final boolean isExperimental){
        super( id, name, source, date );
        this.theoryId       = theoryId;
        this.observationType = observationType;
        this.state          = state;
        this.isExperimental = isExperimental;
        this.isAPrediction  = ( observationType == ObservationType.ANNOTATION ||
                                observationType == ObservationType.COMPUTATIONAL_ANALYSIS );
        this.isAnExpectation= ( observationType == ObservationType.EXPERIMENTATION ||
                                ( observationType == ObservationType.ANNOTATION && isExperimental) );
    }


    public boolean getIsExperimental(){
        return isExperimental;
    }

    public boolean getIsAPrediction(){
        return isAPrediction;
    }

    public boolean getIsAnExpectation(){
        return isAnExpectation;
    }



    @Override
    public String toString() {
        return "Observation( \n" +
               "                     id             = " + id               + ",\n" +
               "                     theoryId       = " + theoryId         + ",\n" +
               "                     name           = " + name             + ",\n" +
               "                     source         = " + source           + ",\n" +
               "                     isExperimental = " + isExperimental   + ",\n" +
               "                     isAPrediction  = " + isAPrediction    + ",\n" +
               "                     isAnExpectation= " + isAnExpectation  + ",\n" +
               "                     observationType= " + observationType  + ",\n" +
               "                     state          = " + state            + " )";
    }
}
