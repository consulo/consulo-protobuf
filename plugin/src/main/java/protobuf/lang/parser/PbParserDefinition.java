package protobuf.lang.parser;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;
import protobuf.file.PbFileElementType;
import protobuf.file.PbFileType;
import protobuf.lang.PbTokenTypes;
import protobuf.lang.lexer.PbMergingLexer;
import protobuf.lang.psi.PbPsiCreator;
import protobuf.lang.psi.impl.PbFileImpl;

/**
 * @author Nikolay Matveev
 * Date: Mar 7, 2010
 */
public class PbParserDefinition implements ParserDefinition {
    public static final IFileElementType PROTOBUF_FILE = new PbFileElementType(PbFileType.PROTOBUF_FILE_TYPE.getLanguage());


    @NotNull
    public Lexer createLexer(LanguageVersion languageVersion) {
        return new PbMergingLexer();
    }

    public PsiParser createParser(LanguageVersion languageVersion) {
        return new PbParser();
    }

    public IFileElementType getFileNodeType() {
        return PROTOBUF_FILE;
    }


    @NotNull
    public TokenSet getWhitespaceTokens(LanguageVersion languageVersion) {
        return PbTokenTypes.WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens(LanguageVersion languageVersion) {
        return PbTokenTypes.COMMENTS;
    }


    @NotNull
    public TokenSet getStringLiteralElements(LanguageVersion languageVersion) {
        return PbTokenTypes.STRING_LITERALS;
    }

    @NotNull
    public PsiElement createElement(ASTNode astNode) {
        return PbPsiCreator.createElement(astNode);
    }


    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new PbFileImpl(fileViewProvider);
    }

    
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MAY; //TODO: fix it        
    }
}
