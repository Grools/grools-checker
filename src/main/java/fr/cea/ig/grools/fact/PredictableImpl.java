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

package fr.cea.ig.grools.fact;


import fr.cea.ig.grools.logic.TruthValuePowerSet;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 */
/*
 * @startuml
 * class PredictableImpl implements Predictable{
 *  - name          : String
 *  - source        : String
 *  - label         : String
 *  - description   : String
 *  - prediction    : TruthValuePowerSet
 *  - type          : RelationType
 *  - isSpecific    : boolean
 * }
 * @enduml
 */
public class PredictableImpl implements Predictable {
    @Getter @NonNull
    private final String name;
    @Getter @NonNull
    private final String source;
    @Getter @NonNull
    private final String label;
    @Getter @NonNull
    private final String description;
    @Getter @Setter
    @NonNull
    private TruthValuePowerSet prediction;
    @Getter
    private final RelationType type = RelationType.PREDICTION;
    private boolean isSpecific;



    @Builder
    @java.beans.ConstructorProperties({"name", "source", "label", "description", "prediction"})
    public PredictableImpl(@NonNull final String name, @NonNull final String source, @NonNull final String label, @NonNull final String description, final TruthValuePowerSet expectation){
        this.name           = name;
        this.source         = source;
        this.label          = label;
        this.description    = description;
        this.prediction    = ( prediction == null ) ? TruthValuePowerSet.n : prediction;
    }


    @Override
    public boolean getIsSpecific( ) {
        return isSpecific;
    }

    @Override
    public void setIsSpecific( boolean isSpecific ) {
        this.isSpecific = isSpecific;
    }
}