package org.n52.test.mock;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.n52.wps.FormatDocument.Format;
import org.n52.wps.io.IGenerator;
import org.n52.wps.io.data.IData;

/**
 *
 * @author tkunicki
 */
public class MockGenerator implements IGenerator {

    public final static List<String> schemaSet;
    public final static List<String> formatSet;
    public final static List<String> encodingSet;

    static {
        schemaSet = Collections.unmodifiableList(new ArrayList(MockUtil.getParserSupportedSchemas(MockParser.class)));
        formatSet = Collections.unmodifiableList(new ArrayList(MockUtil.getParserSupportedFormats(MockParser.class)));
        encodingSet = Collections.unmodifiableList(new ArrayList(MockUtil.getParserSupportedEncodings(MockParser.class)));
    }

//    @Override
//    public OutputStream generate(IData coll) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public Class[] getSupportedInternalInputDataType() {
//        return new Class[] { MockBinding.class };
//    }
    
    @Override
    public boolean isSupportedSchema(String schema) {
        return schemaSet.contains(schema);
    }

    @Override
    public boolean isSupportedFormat(String format) {
        return formatSet.contains(format);
    }

    @Override
    public boolean isSupportedEncoding(String encoding) {
        return encodingSet.contains(encoding);
    }

    @Override
    public String[] getSupportedSchemas() {
        return schemaSet.toArray(new String[0]);
    }

    @Override
    public String[] getSupportedFormats() {
        return formatSet.toArray(new String[0]);
    }

    @Override
    public String[] getSupportedEncodings() {
        return encodingSet.toArray(new String[0]);
    }

    @Override
    public InputStream generateStream(IData data, String mimeType, String schema) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InputStream generateBase64Stream(IData data, String mimeType, String schema) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isSupportedDataBinding(Class<?> clazz) {
        return Arrays.binarySearch(getSupportedDataBindings(), clazz) > -1;
    }

    @Override
    public Format[] getSupportedFullFormats() {
        Format f = Format.Factory.newInstance();
        f.setSchema(schemaSet.get(0));
        f.setEncoding(encodingSet.get(0));
        f.setMimetype(formatSet.get(0));
        return new Format[] {f};
    }

    @Override
    public Class<?>[] getSupportedDataBindings() {
        return new Class[] { MockBinding.class };
    }

}
