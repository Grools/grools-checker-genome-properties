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

import lombok.*;

import java.io.*;
import java.time.*;

/**
 * Fact
 */
/*
 * @startuml
 * skinparam shadowing false
 * skinparam defaultFontName courier
 * abstract class Fact<T extends Term> extends Serializable {
 *  + getId()        : String
 *  + getName()      : String
 *  + getSource()    : String
 *  + getDate()      : LocalDate
 * }
 * @enduml
 */
@Data
public abstract class Fact implements Serializable {
    private static final long serialVersionUID = -4743905609219574762L;
    protected final String    id;
    protected final String    name;
    protected final String    source;
    protected final LocalDate date;

    protected Fact(
                       @NonNull final String id,
                       @NonNull final String name,
                       @NonNull final String source,
                       @NonNull final LocalDate date ) {
        this.id     = id;
        this.name   = name;
        this.source = source;
        this.date   = date;
    }


    protected Fact(
                       @NonNull final String id,
                       @NonNull final String source,
                       @NonNull final LocalDate date ) {
        this(id,  id, source, date );
    }


    protected Fact( @NonNull final String id, @NonNull final String source ) {
        this( id, id, source, LocalDate.now() );
    }


    protected Fact( @NonNull final String id ) {
        this( id, id, "UNKNOWN", LocalDate.now() );
    }
}