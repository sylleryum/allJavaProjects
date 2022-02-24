/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.sylleryum.producer.entity;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EntityTest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -284773414796200947L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EntityTest\",\"namespace\":\"com.sylleryum.producer.entity\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"surname\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EntityTest> ENCODER =
      new BinaryMessageEncoder<EntityTest>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EntityTest> DECODER =
      new BinaryMessageDecoder<EntityTest>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EntityTest> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EntityTest> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EntityTest> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EntityTest>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EntityTest to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EntityTest from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EntityTest instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EntityTest fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence name;
  private java.lang.CharSequence surname;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EntityTest() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param surname The new value for surname
   */
  public EntityTest(java.lang.CharSequence name, java.lang.CharSequence surname) {
    this.name = name;
    this.surname = surname;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return surname;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: surname = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'surname' field.
   * @return The value of the 'surname' field.
   */
  public java.lang.CharSequence getSurname() {
    return surname;
  }


  /**
   * Sets the value of the 'surname' field.
   * @param value the value to set.
   */
  public void setSurname(java.lang.CharSequence value) {
    this.surname = value;
  }

  /**
   * Creates a new EntityTest RecordBuilder.
   * @return A new EntityTest RecordBuilder
   */
  public static com.sylleryum.producer.entity.EntityTest.Builder newBuilder() {
    return new com.sylleryum.producer.entity.EntityTest.Builder();
  }

  /**
   * Creates a new EntityTest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EntityTest RecordBuilder
   */
  public static com.sylleryum.producer.entity.EntityTest.Builder newBuilder(com.sylleryum.producer.entity.EntityTest.Builder other) {
    if (other == null) {
      return new com.sylleryum.producer.entity.EntityTest.Builder();
    } else {
      return new com.sylleryum.producer.entity.EntityTest.Builder(other);
    }
  }

  /**
   * Creates a new EntityTest RecordBuilder by copying an existing EntityTest instance.
   * @param other The existing instance to copy.
   * @return A new EntityTest RecordBuilder
   */
  public static com.sylleryum.producer.entity.EntityTest.Builder newBuilder(com.sylleryum.producer.entity.EntityTest other) {
    if (other == null) {
      return new com.sylleryum.producer.entity.EntityTest.Builder();
    } else {
      return new com.sylleryum.producer.entity.EntityTest.Builder(other);
    }
  }

  /**
   * RecordBuilder for EntityTest instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EntityTest>
    implements org.apache.avro.data.RecordBuilder<EntityTest> {

    private java.lang.CharSequence name;
    private java.lang.CharSequence surname;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.sylleryum.producer.entity.EntityTest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.surname)) {
        this.surname = data().deepCopy(fields()[1].schema(), other.surname);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing EntityTest instance
     * @param other The existing instance to copy.
     */
    private Builder(com.sylleryum.producer.entity.EntityTest other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.surname)) {
        this.surname = data().deepCopy(fields()[1].schema(), other.surname);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.sylleryum.producer.entity.EntityTest.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.sylleryum.producer.entity.EntityTest.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'surname' field.
      * @return The value.
      */
    public java.lang.CharSequence getSurname() {
      return surname;
    }


    /**
      * Sets the value of the 'surname' field.
      * @param value The value of 'surname'.
      * @return This builder.
      */
    public com.sylleryum.producer.entity.EntityTest.Builder setSurname(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.surname = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'surname' field has been set.
      * @return True if the 'surname' field has been set, false otherwise.
      */
    public boolean hasSurname() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'surname' field.
      * @return This builder.
      */
    public com.sylleryum.producer.entity.EntityTest.Builder clearSurname() {
      surname = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EntityTest build() {
      try {
        EntityTest record = new EntityTest();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.surname = fieldSetFlags()[1] ? this.surname : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EntityTest>
    WRITER$ = (org.apache.avro.io.DatumWriter<EntityTest>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EntityTest>
    READER$ = (org.apache.avro.io.DatumReader<EntityTest>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.name);

    out.writeString(this.surname);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.surname = in.readString(this.surname instanceof Utf8 ? (Utf8)this.surname : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 1:
          this.surname = in.readString(this.surname instanceof Utf8 ? (Utf8)this.surname : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










