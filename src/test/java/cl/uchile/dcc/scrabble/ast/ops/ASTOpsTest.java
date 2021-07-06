package cl.uchile.dcc.scrabble.ast.ops;

import cl.uchile.dcc.scrabble.ast.leaves.*;
import cl.uchile.dcc.scrabble.flyweight.TypeFactory;
import cl.uchile.dcc.scrabble.types.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ASTOpsTest {
    private String str, str2;
    private boolean b, b2;
    private double dbl, dbl2;
    private int integer, integer2;
    private String bin, bin2;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(20);
        str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        str2 = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);

        b = rng.nextBoolean();
        b2 = rng.nextBoolean();

        dbl = rng.nextDouble();
        dbl2 = rng.nextDouble();

        integer = rng.nextInt();
        integer2 = rng.nextInt();

        char[] bins = {'0', '1'};
        int binSize;
        do { binSize= rng.nextInt(31); } while (binSize == 0 || binSize == 1);
        bin = RandomStringUtils.random(binSize, 0, 0,
                false, true, bins, rng);
        bin2 = RandomStringUtils.random(binSize, 0, 0,
                false, true, bins, rng);

    }

    @RepeatedTest(20)
    void addTest(){
        //String adds (all are valid)
        Add strstr = new Add(new CString(str), new CString(str2));
        assertEquals(TypeFactory.createString(str).add(TypeFactory.createString(str2)), strstr.eval().getType());

        Add strbool = new Add(new CString(str), new CBool(b));
        assertEquals(TypeFactory.createString(str).add(TypeFactory.createBool(b)), strbool.eval().getType());

        Add strflt = new Add(new CString(str), new CFloat(dbl));
        assertEquals(TypeFactory.createString(str).add(TypeFactory.createFloat(dbl)), strflt.eval().getType());

        Add strint = new Add(new CString(str), new CInt(integer));
        assertEquals(TypeFactory.createString(str).add(TypeFactory.createInt(integer)), strint.eval().getType());

        Add strbin = new Add(new CString(str), new CBinary(bin));
        assertEquals(TypeFactory.createString(str).add(TypeFactory.createBinary(bin)), strbin.eval().getType());

        //Bool adds (none is valid)
        Add boolbool = new Add(new CBool(b), new CBool(b2));
        assertNull(boolbool.eval());

        Add boolstr = new Add(new CBool(b), new CString(str));
        assertNull(boolstr.eval());

        Add boolflt = new Add(new CBool(b), new CFloat(dbl));
        assertNull(boolflt.eval());

        Add boolint = new Add(new CBool(b), new CInt(integer));
        assertNull(boolint.eval());

        Add boolbin = new Add(new CBool(b), new CBinary(bin));
        assertNull(boolbin.eval());

        //Float adds (numbers are valid)
        Add fltflt = new Add(new CFloat(dbl), new CFloat(dbl2));
        assertEquals(TypeFactory.createFloat(dbl).add(TypeFactory.createFloat(dbl2)), fltflt.eval().getType());

        Add fltint = new Add(new CFloat(dbl), new CInt(integer));
        assertEquals(TypeFactory.createFloat(dbl).add(TypeFactory.createInt(integer)), fltint.eval().getType());

        Add fltbin = new Add(new CFloat(dbl), new CBinary(bin));
        assertEquals(TypeFactory.createFloat(dbl).add(TypeFactory.createBinary(bin)), fltbin.eval().getType());

        Add fltstr = new Add(new CFloat(dbl), new CString(str));
        assertNull(fltstr.eval());

        Add fltbool = new Add(new CFloat(dbl), new CBool(b));
        assertNull(fltbool.eval());

        //Int adds (numbers are valid)
        Add intint = new Add(new CInt(integer), new CInt(integer2));
        assertEquals(TypeFactory.createInt(integer).add(TypeFactory.createInt(integer2)), intint.eval().getType());

        Add intflt = new Add(new CInt(integer), new CFloat(dbl));
        assertEquals(TypeFactory.createInt(integer).add(TypeFactory.createFloat(dbl)), intflt.eval().getType());

        Add intbin = new Add(new CInt(integer), new CBinary(bin));
        assertEquals(TypeFactory.createInt(integer).add(TypeFactory.createBinary(bin)), intbin.eval().getType());

        Add intstr = new Add(new CInt(integer), new CString(str));
        assertNull(intstr.eval());

        Add intbool = new Add(new CInt(integer), new CBool(b));
        assertNull(intbool.eval());

        //Binary adds (itself and ints are valid)
        Add binbin = new Add(new CBinary(bin), new CBinary(bin2));
        assertEquals(TypeFactory.createBinary(bin).add(TypeFactory.createBinary(bin2)), binbin.eval().getType());

        Add binint = new Add(new CBinary(bin), new CInt(integer));
        assertEquals(TypeFactory.createBinary(bin).add(TypeFactory.createInt(integer)), binint.eval().getType());

        Add binflt = new Add(new CBinary(bin), new CFloat(dbl));
        assertNull(binflt.eval());

        Add binstr = new Add(new CBinary(bin), new CString(str));
        assertNull(binstr.eval());

        Add binbool = new Add(new CBinary(bin), new CBool(b));
        assertNull(binbool.eval());
    }
    
    @RepeatedTest(20)
    void subTest() {
        //String subs (all are null)
        Sub strstr = new Sub(new CString(str), new CString(str2));
        assertNull(strstr.eval());

        Sub strbool = new Sub(new CString(str), new CBool(b));
        assertNull(strbool.eval());

        Sub strflt = new Sub(new CString(str), new CFloat(dbl));
        assertNull(strflt.eval());

        Sub strint = new Sub(new CString(str), new CInt(integer));
        assertNull(strint.eval());

        Sub strbin = new Sub(new CString(str), new CBinary(bin));
        assertNull(strbin.eval());

        //Bool subs (none is valid)
        Sub boolbool = new Sub(new CBool(b), new CBool(b2));
        assertNull(boolbool.eval());

        Sub boolstr = new Sub(new CBool(b), new CString(str));
        assertNull(boolstr.eval());

        Sub boolflt = new Sub(new CBool(b), new CFloat(dbl));
        assertNull(boolflt.eval());

        Sub boolint = new Sub(new CBool(b), new CInt(integer));
        assertNull(boolint.eval());

        Sub boolbin = new Sub(new CBool(b), new CBinary(bin));
        assertNull(boolbin.eval());

        //Float sub (numbers are valid)
        Sub fltflt = new Sub(new CFloat(dbl), new CFloat(dbl2));
        assertEquals(TypeFactory.createFloat(dbl).sub(TypeFactory.createFloat(dbl2)), fltflt.eval().getType());

        Sub fltint = new Sub(new CFloat(dbl), new CInt(integer));
        assertEquals(TypeFactory.createFloat(dbl).sub(TypeFactory.createInt(integer)), fltint.eval().getType());

        Sub fltbin = new Sub(new CFloat(dbl), new CBinary(bin));
        assertEquals(TypeFactory.createFloat(dbl).sub(TypeFactory.createBinary(bin)), fltbin.eval().getType());

        Sub fltstr = new Sub(new CFloat(dbl), new CString(str));
        assertNull(fltstr.eval());

        Sub fltbool = new Sub(new CFloat(dbl), new CBool(b));
        assertNull(fltbool.eval());

        //Int subs (numbers are valid)
        Sub intint = new Sub(new CInt(integer), new CInt(integer2));
        assertEquals(TypeFactory.createInt(integer).sub(TypeFactory.createInt(integer2)), intint.eval().getType());

        Sub intflt = new Sub(new CInt(integer), new CFloat(dbl));
        assertEquals(TypeFactory.createInt(integer).sub(TypeFactory.createFloat(dbl)), intflt.eval().getType());

        Sub intbin = new Sub(new CInt(integer), new CBinary(bin));
        assertEquals(TypeFactory.createInt(integer).sub(TypeFactory.createBinary(bin)), intbin.eval().getType());

        Sub intstr = new Sub(new CInt(integer), new CString(str));
        assertNull(intstr.eval());

        Sub intbool = new Sub(new CInt(integer), new CBool(b));
        assertNull(intbool.eval());

        //Binary subs (itself and ints are valid)
        Sub binbin = new Sub(new CBinary(bin), new CBinary(bin2));
        assertEquals(TypeFactory.createBinary(bin).sub(TypeFactory.createBinary(bin2)), binbin.eval().getType());

        Sub binint = new Sub(new CBinary(bin), new CInt(integer));
        assertEquals(TypeFactory.createBinary(bin).sub(TypeFactory.createInt(integer)), binint.eval().getType());

        Sub binflt = new Sub(new CBinary(bin), new CFloat(dbl));
        assertNull(binflt.eval());

        Sub binstr = new Sub(new CBinary(bin), new CString(str));
        assertNull(binstr.eval());

        Sub binbool = new Sub(new CBinary(bin), new CBool(b));
        assertNull(binbool.eval());
    }

    @RepeatedTest(20)
    void multTest() {
        //String mults (all are null)
        Mult strstr = new Mult(new CString(str), new CString(str2));
        assertNull(strstr.eval());

        Mult strbool = new Mult(new CString(str), new CBool(b));
        assertNull(strbool.eval());

        Mult strflt = new Mult(new CString(str), new CFloat(dbl));
        assertNull(strflt.eval());

        Mult strint = new Mult(new CString(str), new CInt(integer));
        assertNull(strint.eval());

        Mult strbin = new Mult(new CString(str), new CBinary(bin));
        assertNull(strbin.eval());

        //Bool mults (none is valid)
        Mult boolbool = new Mult(new CBool(b), new CBool(b2));
        assertNull(boolbool.eval());

        Mult boolstr = new Mult(new CBool(b), new CString(str));
        assertNull(boolstr.eval());

        Mult boolflt = new Mult(new CBool(b), new CFloat(dbl));
        assertNull(boolflt.eval());

        Mult boolint = new Mult(new CBool(b), new CInt(integer));
        assertNull(boolint.eval());

        Mult boolbin = new Mult(new CBool(b), new CBinary(bin));
        assertNull(boolbin.eval());

        //Float mults (numbers are valid)
        Mult fltflt = new Mult(new CFloat(dbl), new CFloat(dbl2));
        assertEquals(TypeFactory.createFloat(dbl).mult(TypeFactory.createFloat(dbl2)), fltflt.eval().getType());

        Mult fltint = new Mult(new CFloat(dbl), new CInt(integer));
        assertEquals(TypeFactory.createFloat(dbl).mult(TypeFactory.createInt(integer)), fltint.eval().getType());

        Mult fltbin = new Mult(new CFloat(dbl), new CBinary(bin));
        assertEquals(TypeFactory.createFloat(dbl).mult(TypeFactory.createBinary(bin)), fltbin.eval().getType());

        Mult fltstr = new Mult(new CFloat(dbl), new CString(str));
        assertNull(fltstr.eval());

        Mult fltbool = new Mult(new CFloat(dbl), new CBool(b));
        assertNull(fltbool.eval());

        //Int mults (numbers are valid)
        Mult intint = new Mult(new CInt(integer), new CInt(integer2));
        assertEquals(TypeFactory.createInt(integer).mult(TypeFactory.createInt(integer2)), intint.eval().getType());

        Mult intflt = new Mult(new CInt(integer), new CFloat(dbl));
        assertEquals(TypeFactory.createInt(integer).mult(TypeFactory.createFloat(dbl)), intflt.eval().getType());

        Mult intbin = new Mult(new CInt(integer), new CBinary(bin));
        assertEquals(TypeFactory.createInt(integer).mult(TypeFactory.createBinary(bin)), intbin.eval().getType());

        Mult intstr = new Mult(new CInt(integer), new CString(str));
        assertNull(intstr.eval());

        Mult intbool = new Mult(new CInt(integer), new CBool(b));
        assertNull(intbool.eval());

        //Binary mults (itself and ints are valid)
        Mult binbin = new Mult(new CBinary(bin), new CBinary(bin2));
        assertEquals(TypeFactory.createBinary(bin).mult(TypeFactory.createBinary(bin2)), binbin.eval().getType());

        Mult binint = new Mult(new CBinary(bin), new CInt(integer));
        assertEquals(TypeFactory.createBinary(bin).mult(TypeFactory.createInt(integer)), binint.eval().getType());

        Mult binflt = new Mult(new CBinary(bin), new CFloat(dbl));
        assertNull(binflt.eval());

        Mult binstr = new Mult(new CBinary(bin), new CString(str));
        assertNull(binstr.eval());

        Mult binbool = new Mult(new CBinary(bin), new CBool(b));
        assertNull(binbool.eval());
    }

    @RepeatedTest(20)
    void divTest() {
        if (dbl2 == 0) {
            dbl2 = 0.1;
        }

        if (integer2 == 0) {
            integer2 = 1;
        }

        if (TypeFactory.createBinary(bin2).toInt() == 0) {
            bin2 = "00001";
        }

        //String divs (all are null)
        Div strstr = new Div(new CString(str), new CString(str2));
        assertNull(strstr.eval());

        Div strbool = new Div(new CString(str), new CBool(b));
        assertNull(strbool.eval());

        Div strflt = new Div(new CString(str), new CFloat(dbl));
        assertNull(strflt.eval());

        Div strint = new Div(new CString(str), new CInt(integer));
        assertNull(strint.eval());

        Div strbin = new Div(new CString(str), new CBinary(bin));
        assertNull(strbin.eval());

        //Bool divs (none is valid)
        Div boolbool = new Div(new CBool(b), new CBool(b2));
        assertNull(boolbool.eval());

        Div boolstr = new Div(new CBool(b), new CString(str));
        assertNull(boolstr.eval());

        Div boolflt = new Div(new CBool(b), new CFloat(dbl));
        assertNull(boolflt.eval());

        Div boolint = new Div(new CBool(b), new CInt(integer));
        assertNull(boolint.eval());

        Div boolbin = new Div(new CBool(b), new CBinary(bin));
        assertNull(boolbin.eval());

        //Float divs (numbers are valid)
        Div fltflt = new Div(new CFloat(dbl), new CFloat(dbl2));
        assertEquals(TypeFactory.createFloat(dbl).div(TypeFactory.createFloat(dbl2)), fltflt.eval().getType());

        Div fltint = new Div(new CFloat(dbl), new CInt(integer2));
        assertEquals(TypeFactory.createFloat(dbl).div(TypeFactory.createInt(integer2)), fltint.eval().getType());

        Div fltbin = new Div(new CFloat(dbl), new CBinary(bin2));
        assertEquals(TypeFactory.createFloat(dbl).div(TypeFactory.createBinary(bin2)), fltbin.eval().getType());

        Div fltstr = new Div(new CFloat(dbl), new CString(str));
        assertNull(fltstr.eval());

        Div fltbool = new Div(new CFloat(dbl), new CBool(b));
        assertNull(fltbool.eval());

        //Int divs (numbers are valid)
        Div intint = new Div(new CInt(integer), new CInt(integer2));
        assertEquals(TypeFactory.createInt(integer).div(TypeFactory.createInt(integer2)), intint.eval().getType());

        Div intflt = new Div(new CInt(integer), new CFloat(dbl2));
        assertEquals(TypeFactory.createInt(integer).div(TypeFactory.createFloat(dbl2)), intflt.eval().getType());

        Div intbin = new Div(new CInt(integer), new CBinary(bin2));
        assertEquals(TypeFactory.createInt(integer).div(TypeFactory.createBinary(bin2)), intbin.eval().getType());

        Div intstr = new Div(new CInt(integer), new CString(str));
        assertNull(intstr.eval());

        Div intbool = new Div(new CInt(integer), new CBool(b));
        assertNull(intbool.eval());

        //Binary divs (itself and ints are valid)
        Div binbin = new Div(new CBinary(bin), new CBinary(bin2));
        assertEquals(TypeFactory.createBinary(bin).div(TypeFactory.createBinary(bin2)), binbin.eval().getType());

        Div binint = new Div(new CBinary(bin), new CInt(integer2));
        assertEquals(TypeFactory.createBinary(bin).div(TypeFactory.createInt(integer2)), binint.eval().getType());

        Div binflt = new Div(new CBinary(bin), new CFloat(dbl));
        assertNull(binflt.eval());

        Div binstr = new Div(new CBinary(bin), new CString(str));
        assertNull(binstr.eval());

        Div binbool = new Div(new CBinary(bin), new CBool(b));
        assertNull(binbool.eval());
    }

    @RepeatedTest(20)
    void orTest(){
        //String ors (all are null)
        Or strstr = new Or(new CString(str), new CString(str2));
        assertNull(strstr.eval());

        Or strbool = new Or(new CString(str), new CBool(b));
        assertNull(strbool.eval());

        Or strflt = new Or(new CString(str), new CFloat(dbl));
        assertNull(strflt.eval());

        Or strint = new Or(new CString(str), new CInt(integer));
        assertNull(strint.eval());

        Or strbin = new Or(new CString(str), new CBinary(bin));
        assertNull(strbin.eval());

        //Bool ors (itself and Binary)
        Or boolbool = new Or(new CBool(b), new CBool(b2));
        assertEquals(TypeFactory.createBool(b).or(TypeFactory.createBool(b2)), boolbool.eval().getType());

        Or boolbin = new Or(new CBool(b), new CBinary(bin));
        assertEquals(TypeFactory.createBool(b).or(TypeFactory.createBinary(bin)), boolbin.eval().getType());

        Or boolstr = new Or(new CBool(b), new CString(str));
        assertNull(boolstr.eval());

        Or boolflt = new Or(new CBool(b), new CFloat(dbl));
        assertNull(boolflt.eval());

        Or boolint = new Or(new CBool(b), new CInt(integer));
        assertNull(boolint.eval());


        //Float ors (all invalid)
        Or fltflt = new Or(new CFloat(dbl), new CFloat(dbl2));
        assertNull(fltflt.eval());

        Or fltint = new Or(new CFloat(dbl), new CInt(integer));
        assertNull(fltint.eval());

        Or fltbin = new Or(new CFloat(dbl), new CBinary(bin));
        assertNull(fltbin.eval());

        Or fltstr = new Or(new CFloat(dbl), new CString(str));
        assertNull(fltstr.eval());

        Or fltbool = new Or(new CFloat(dbl), new CBool(b));
        assertNull(fltbool.eval());

        //Int ors (all invalid)
        Or intint = new Or(new CInt(integer), new CInt(integer2));
        assertNull(intint.eval());

        Or intflt = new Or(new CInt(integer), new CFloat(dbl));
        assertNull(intflt.eval());

        Or intbin = new Or(new CInt(integer), new CBinary(bin));
        assertNull(intbin.eval());

        Or intstr = new Or(new CInt(integer), new CString(str));
        assertNull(intstr.eval());

        Or intbool = new Or(new CInt(integer), new CBool(b));
        assertNull(intbool.eval());

        //Binary ors (itself and bools are valid)
        Or binbin = new Or(new CBinary(bin), new CBinary(bin2));
        assertEquals(TypeFactory.createBinary(bin).or(TypeFactory.createBinary(bin2)), binbin.eval().getType());

        Or binbool = new Or(new CBinary(bin), new CBool(b));
        assertEquals(TypeFactory.createBinary(bin).or(TypeFactory.createBool(b)), binbool.eval().getType());

        Or binint = new Or(new CBinary(bin), new CInt(integer));
        assertNull(binint.eval());

        Or binflt = new Or(new CBinary(bin), new CFloat(dbl));
        assertNull(binflt.eval());

        Or binstr = new Or(new CBinary(bin), new CString(str));
        assertNull(binstr.eval());
    }

    @RepeatedTest(20)
    void andTest() {
        //String ors (all are null)
        And strstr = new And(new CString(str), new CString(str2));
        assertNull(strstr.eval());

        And strbool = new And(new CString(str), new CBool(b));
        assertNull(strbool.eval());

        And strflt = new And(new CString(str), new CFloat(dbl));
        assertNull(strflt.eval());

        And strint = new And(new CString(str), new CInt(integer));
        assertNull(strint.eval());

        And strbin = new And(new CString(str), new CBinary(bin));
        assertNull(strbin.eval());

        //Bool ors (itself and Binary)
        And boolbool = new And(new CBool(b), new CBool(b2));
        assertEquals(TypeFactory.createBool(b).and(TypeFactory.createBool(b2)), boolbool.eval().getType());

        And boolbin = new And(new CBool(b), new CBinary(bin));
        assertEquals(TypeFactory.createBool(b).and(TypeFactory.createBinary(bin)), boolbin.eval().getType());

        And boolstr = new And(new CBool(b), new CString(str));
        assertNull(boolstr.eval());

        And boolflt = new And(new CBool(b), new CFloat(dbl));
        assertNull(boolflt.eval());

        And boolint = new And(new CBool(b), new CInt(integer));
        assertNull(boolint.eval());


        //Float ors (all invalid)
        And fltflt = new And(new CFloat(dbl), new CFloat(dbl2));
        assertNull(fltflt.eval());

        And fltint = new And(new CFloat(dbl), new CInt(integer));
        assertNull(fltint.eval());

        And fltbin = new And(new CFloat(dbl), new CBinary(bin));
        assertNull(fltbin.eval());

        And fltstr = new And(new CFloat(dbl), new CString(str));
        assertNull(fltstr.eval());

        And fltbool = new And(new CFloat(dbl), new CBool(b));
        assertNull(fltbool.eval());

        //Int ors (all invalid)
        And intint = new And(new CInt(integer), new CInt(integer2));
        assertNull(intint.eval());

        And intflt = new And(new CInt(integer), new CFloat(dbl));
        assertNull(intflt.eval());

        And intbin = new And(new CInt(integer), new CBinary(bin));
        assertNull(intbin.eval());

        And intstr = new And(new CInt(integer), new CString(str));
        assertNull(intstr.eval());

        And intbool = new And(new CInt(integer), new CBool(b));
        assertNull(intbool.eval());

        //Binary ors (itself and bools are valid)
        And binbin = new And(new CBinary(bin), new CBinary(bin2));
        assertEquals(TypeFactory.createBinary(bin).and(TypeFactory.createBinary(bin2)), binbin.eval().getType());

        And binbool = new And(new CBinary(bin), new CBool(b));
        assertEquals(TypeFactory.createBinary(bin).and(TypeFactory.createBool(b)), binbool.eval().getType());

        And binint = new And(new CBinary(bin), new CInt(integer));
        assertNull(binint.eval());

        And binflt = new And(new CBinary(bin), new CFloat(dbl));
        assertNull(binflt.eval());

        And binstr = new And(new CBinary(bin), new CString(str));
        assertNull(binstr.eval());
    }

    @RepeatedTest(20)
    void negateTest() {
        Negate negstr = new Negate(new CString(str));
        assertNull(negstr.eval());

        Negate negbool = new Negate(new CBool(b));
        assertEquals(TypeFactory.createBool(b).negate(), negbool.eval().getType());

        Negate negflt = new Negate(new CFloat(dbl));
        assertNull(negflt.eval());

        Negate negint = new Negate(new CInt(integer));
        assertNull(negint.eval());

        Negate negbin = new Negate(new CBinary(bin));
        assertEquals(TypeFactory.createBinary(bin).negate(), negbin.eval().getType());
    }

    @RepeatedTest(20)
    void toCTypesOpsTest() {
        // Only one null case of each operation will be tested
        // for every null case check specific operation tests

        // toCString
        Add addvalid = new Add(new CString(str), new CBool(b));
        assertEquals(TypeFactory.createString(str).add(TypeFactory.createBool(b)), addvalid.toCString().getType());

        Add addnull = new Add(new CInt(integer), new CString(str));
        assertNull(addnull.toCString());

        // toCFloat
        Sub subvalid = new Sub(new CFloat(dbl), new CInt(integer));
        assertEquals(TypeFactory.createFloat(dbl).sub(TypeFactory.createInt(integer)).toTFloat(),
                subvalid.toCFloat().getType());

        Sub subnull = new Sub(new CInt(integer), new CBool(b));
        assertNull(subnull.toCFloat());

        // toCBinary
        Mult multvalid = new Mult(new CInt(integer), new CBinary(bin));
        TInt result = (TInt) TypeFactory.createInt(integer).mult(TypeFactory.createBinary(bin));
        assertEquals(result.toTBinary(), multvalid.toCBinary().getType());

        Mult multnull = new Mult(new CBool(b), new CBool(b2));
        assertNull(multnull.toCBinary());

        // toCInt
        if (integer == 0) {
            integer = 1;
        }
        Div divvalid = new Div(new CBinary(bin), new CInt(integer));
        assertEquals(TypeFactory.createBinary(bin).div(TypeFactory.createInt(integer)).toTInt(),
                divvalid.toCInt().getType());

        Div divnull = new Div(new CString(str), new CBool(b));
        assertNull(divnull.toCInt());

        // toCBool
        Or orvalid = new Or(new CBool(b), new CBool(b2));
        TBool res = (TBool) TypeFactory.createBool(b).or(TypeFactory.createBool(b2));
        assertEquals(res.toTBool(), orvalid.toCBool().getType());

        Or ornull = new Or(new CString(str), new CInt(integer));
        assertNull(ornull.toCBool());

    }

    @RepeatedTest(20)
    void toCTypesLeafsTest(){
        // CString transformations
        CString cstr = new CString(str);
        assertEquals(cstr, cstr.toCString());
        assertNull(cstr.toCBinary());
        assertNull(cstr.toCBool());
        assertNull(cstr.toCFloat());
        assertNull(cstr.toCInt());

        // CBool transformations
        CBool cbool = new CBool(b);
        assertEquals(cbool.getType().toTString(), cbool.toCString().getType());
        assertNull(cstr.toCBinary());
        assertEquals(cbool, cbool.toCBool());
        assertNull(cstr.toCFloat());
        assertNull(cstr.toCInt());

        // CBinary transformations
        CBinary cbin = new CBinary(bin);
        assertEquals(cbin.getType().toTString(), cbin.toCString().getType());
        assertEquals(cbin, cbin.toCBinary());
        assertNull(cbin.toCBool());
        TBinary tbin = (TBinary) cbin.getType();
        assertEquals(tbin.toTFloat(), cbin.toCFloat().getType());
        assertEquals(tbin.toTInt(), cbin.toCInt().getType());

        // CFloat transformations
        CFloat cflt = new CFloat(dbl);
        TFloat tflt = (TFloat) cflt.getType();
        assertEquals(tflt.toTString(), cflt.toCString().getType());
        assertNull(cflt.toCBinary());
        assertNull(cflt.toCBool());
        assertEquals(tflt.toTFloat(), cflt.toCFloat().getType());
        assertNull(cflt.toCInt());

        // CInt transformations
        CInt cint = new CInt(integer);
        TInt tint = (TInt) cint.getType();
        assertEquals(tint.toTString(), cint.toCString().getType());
        assertEquals(tint.toTBinary(), cint.toCBinary().getType());
        assertNull(cint.toCBool());
        assertEquals(tint.toTFloat(), cint.toCFloat().getType());
        assertEquals(cint, cint.toCInt());
    }
}