package protobuf.lang.psi.impl.definitions;

import com.intellij.lang.ASTNode;
import protobuf.lang.psi.api.blocks.PbBlock;
import protobuf.lang.psi.api.definitions.PbExtendDef;
import protobuf.lang.psi.api.members.PbFieldType;
import protobuf.lang.psi.api.references.PbRef;
import protobuf.lang.psi.impl.auxiliary.PbBlockHolderImpl;

/**
 * author: Nikolay Matveev
 * Date: Mar 12, 2010
 */

//todo: inspection that nested 'extend' is bad
public class PbExtendDefImpl extends PbBlockHolderImpl implements PbExtendDef {
    public PbExtendDefImpl(ASTNode node){
        super(node);
    }

    @Override
    public PbRef getTypeRef() {
        return findChildByClass(PbRef.class);        
    }
}