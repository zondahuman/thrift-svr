/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.abin.lee.thrift.model;

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.*;

public class Contact implements org.apache.thrift.TBase<Contact, Contact._Fields>, java.io.Serializable, Cloneable, Comparable<Contact> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Contact");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField BIRTHDAY_FIELD_DESC = new org.apache.thrift.protocol.TField("birthday", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField PHONE_NO_FIELD_DESC = new org.apache.thrift.protocol.TField("phoneNo", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField IP_ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("ipAddress", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PROPS_FIELD_DESC = new org.apache.thrift.protocol.TField("props", org.apache.thrift.protocol.TType.MAP, (short)6);
  private static final org.apache.thrift.protocol.TField SALARY_FIELD_DESC = new org.apache.thrift.protocol.TField("salary", org.apache.thrift.protocol.TType.DOUBLE, (short)7);
  private static final org.apache.thrift.protocol.TField BOOKS_FIELD_DESC = new org.apache.thrift.protocol.TField("books", org.apache.thrift.protocol.TType.SET, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ContactStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ContactTupleSchemeFactory());
  }

  public int id; // required
  public String name; // required
  public long birthday; // required
  public String phoneNo; // required
  public String ipAddress; // required
  public Map<String,String> props; // required
  public double salary; // required
  public Set<Book> books; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    NAME((short)2, "name"),
    BIRTHDAY((short)3, "birthday"),
    PHONE_NO((short)4, "phoneNo"),
    IP_ADDRESS((short)5, "ipAddress"),
    PROPS((short)6, "props"),
    SALARY((short)7, "salary"),
    BOOKS((short)8, "books");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // NAME
          return NAME;
        case 3: // BIRTHDAY
          return BIRTHDAY;
        case 4: // PHONE_NO
          return PHONE_NO;
        case 5: // IP_ADDRESS
          return IP_ADDRESS;
        case 6: // PROPS
          return PROPS;
        case 7: // SALARY
          return SALARY;
        case 8: // BOOKS
          return BOOKS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __BIRTHDAY_ISSET_ID = 1;
  private static final int __SALARY_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BIRTHDAY, new org.apache.thrift.meta_data.FieldMetaData("birthday", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.PHONE_NO, new org.apache.thrift.meta_data.FieldMetaData("phoneNo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IP_ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("ipAddress", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROPS, new org.apache.thrift.meta_data.FieldMetaData("props", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.SALARY, new org.apache.thrift.meta_data.FieldMetaData("salary", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.BOOKS, new org.apache.thrift.meta_data.FieldMetaData("books", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Book.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Contact.class, metaDataMap);
  }

  public Contact() {
  }

  public Contact(
    int id,
    String name,
    long birthday,
    String phoneNo,
    String ipAddress,
    Map<String,String> props,
    double salary,
    Set<Book> books)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.name = name;
    this.birthday = birthday;
    setBirthdayIsSet(true);
    this.phoneNo = phoneNo;
    this.ipAddress = ipAddress;
    this.props = props;
    this.salary = salary;
    setSalaryIsSet(true);
    this.books = books;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Contact(Contact other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.birthday = other.birthday;
    if (other.isSetPhoneNo()) {
      this.phoneNo = other.phoneNo;
    }
    if (other.isSetIpAddress()) {
      this.ipAddress = other.ipAddress;
    }
    if (other.isSetProps()) {
      Map<String,String> __this__props = new HashMap<String,String>(other.props);
      this.props = __this__props;
    }
    this.salary = other.salary;
    if (other.isSetBooks()) {
      Set<Book> __this__books = new HashSet<Book>(other.books.size());
      for (Book other_element : other.books) {
        __this__books.add(new Book(other_element));
      }
      this.books = __this__books;
    }
  }

  public Contact deepCopy() {
    return new Contact(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.name = null;
    setBirthdayIsSet(false);
    this.birthday = 0;
    this.phoneNo = null;
    this.ipAddress = null;
    this.props = null;
    setSalaryIsSet(false);
    this.salary = 0.0;
    this.books = null;
  }

  public int getId() {
    return this.id;
  }

  public Contact setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public String getName() {
    return this.name;
  }

  public Contact setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public long getBirthday() {
    return this.birthday;
  }

  public Contact setBirthday(long birthday) {
    this.birthday = birthday;
    setBirthdayIsSet(true);
    return this;
  }

  public void unsetBirthday() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BIRTHDAY_ISSET_ID);
  }

  /** Returns true if field birthday is set (has been assigned a value) and false otherwise */
  public boolean isSetBirthday() {
    return EncodingUtils.testBit(__isset_bitfield, __BIRTHDAY_ISSET_ID);
  }

  public void setBirthdayIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BIRTHDAY_ISSET_ID, value);
  }

  public String getPhoneNo() {
    return this.phoneNo;
  }

  public Contact setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
    return this;
  }

  public void unsetPhoneNo() {
    this.phoneNo = null;
  }

  /** Returns true if field phoneNo is set (has been assigned a value) and false otherwise */
  public boolean isSetPhoneNo() {
    return this.phoneNo != null;
  }

  public void setPhoneNoIsSet(boolean value) {
    if (!value) {
      this.phoneNo = null;
    }
  }

  public String getIpAddress() {
    return this.ipAddress;
  }

  public Contact setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

  public void unsetIpAddress() {
    this.ipAddress = null;
  }

  /** Returns true if field ipAddress is set (has been assigned a value) and false otherwise */
  public boolean isSetIpAddress() {
    return this.ipAddress != null;
  }

  public void setIpAddressIsSet(boolean value) {
    if (!value) {
      this.ipAddress = null;
    }
  }

  public int getPropsSize() {
    return (this.props == null) ? 0 : this.props.size();
  }

  public void putToProps(String key, String val) {
    if (this.props == null) {
      this.props = new HashMap<String,String>();
    }
    this.props.put(key, val);
  }

  public Map<String,String> getProps() {
    return this.props;
  }

  public Contact setProps(Map<String,String> props) {
    this.props = props;
    return this;
  }

  public void unsetProps() {
    this.props = null;
  }

  /** Returns true if field props is set (has been assigned a value) and false otherwise */
  public boolean isSetProps() {
    return this.props != null;
  }

  public void setPropsIsSet(boolean value) {
    if (!value) {
      this.props = null;
    }
  }

  public double getSalary() {
    return this.salary;
  }

  public Contact setSalary(double salary) {
    this.salary = salary;
    setSalaryIsSet(true);
    return this;
  }

  public void unsetSalary() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SALARY_ISSET_ID);
  }

  /** Returns true if field salary is set (has been assigned a value) and false otherwise */
  public boolean isSetSalary() {
    return EncodingUtils.testBit(__isset_bitfield, __SALARY_ISSET_ID);
  }

  public void setSalaryIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SALARY_ISSET_ID, value);
  }

  public int getBooksSize() {
    return (this.books == null) ? 0 : this.books.size();
  }

  public java.util.Iterator<Book> getBooksIterator() {
    return (this.books == null) ? null : this.books.iterator();
  }

  public void addToBooks(Book elem) {
    if (this.books == null) {
      this.books = new HashSet<Book>();
    }
    this.books.add(elem);
  }

  public Set<Book> getBooks() {
    return this.books;
  }

  public Contact setBooks(Set<Book> books) {
    this.books = books;
    return this;
  }

  public void unsetBooks() {
    this.books = null;
  }

  /** Returns true if field books is set (has been assigned a value) and false otherwise */
  public boolean isSetBooks() {
    return this.books != null;
  }

  public void setBooksIsSet(boolean value) {
    if (!value) {
      this.books = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case BIRTHDAY:
      if (value == null) {
        unsetBirthday();
      } else {
        setBirthday((Long)value);
      }
      break;

    case PHONE_NO:
      if (value == null) {
        unsetPhoneNo();
      } else {
        setPhoneNo((String)value);
      }
      break;

    case IP_ADDRESS:
      if (value == null) {
        unsetIpAddress();
      } else {
        setIpAddress((String)value);
      }
      break;

    case PROPS:
      if (value == null) {
        unsetProps();
      } else {
        setProps((Map<String,String>)value);
      }
      break;

    case SALARY:
      if (value == null) {
        unsetSalary();
      } else {
        setSalary((Double)value);
      }
      break;

    case BOOKS:
      if (value == null) {
        unsetBooks();
      } else {
        setBooks((Set<Book>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return Integer.valueOf(getId());

    case NAME:
      return getName();

    case BIRTHDAY:
      return Long.valueOf(getBirthday());

    case PHONE_NO:
      return getPhoneNo();

    case IP_ADDRESS:
      return getIpAddress();

    case PROPS:
      return getProps();

    case SALARY:
      return Double.valueOf(getSalary());

    case BOOKS:
      return getBooks();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case NAME:
      return isSetName();
    case BIRTHDAY:
      return isSetBirthday();
    case PHONE_NO:
      return isSetPhoneNo();
    case IP_ADDRESS:
      return isSetIpAddress();
    case PROPS:
      return isSetProps();
    case SALARY:
      return isSetSalary();
    case BOOKS:
      return isSetBooks();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Contact)
      return this.equals((Contact)that);
    return false;
  }

  public boolean equals(Contact that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_birthday = true;
    boolean that_present_birthday = true;
    if (this_present_birthday || that_present_birthday) {
      if (!(this_present_birthday && that_present_birthday))
        return false;
      if (this.birthday != that.birthday)
        return false;
    }

    boolean this_present_phoneNo = true && this.isSetPhoneNo();
    boolean that_present_phoneNo = true && that.isSetPhoneNo();
    if (this_present_phoneNo || that_present_phoneNo) {
      if (!(this_present_phoneNo && that_present_phoneNo))
        return false;
      if (!this.phoneNo.equals(that.phoneNo))
        return false;
    }

    boolean this_present_ipAddress = true && this.isSetIpAddress();
    boolean that_present_ipAddress = true && that.isSetIpAddress();
    if (this_present_ipAddress || that_present_ipAddress) {
      if (!(this_present_ipAddress && that_present_ipAddress))
        return false;
      if (!this.ipAddress.equals(that.ipAddress))
        return false;
    }

    boolean this_present_props = true && this.isSetProps();
    boolean that_present_props = true && that.isSetProps();
    if (this_present_props || that_present_props) {
      if (!(this_present_props && that_present_props))
        return false;
      if (!this.props.equals(that.props))
        return false;
    }

    boolean this_present_salary = true;
    boolean that_present_salary = true;
    if (this_present_salary || that_present_salary) {
      if (!(this_present_salary && that_present_salary))
        return false;
      if (this.salary != that.salary)
        return false;
    }

    boolean this_present_books = true && this.isSetBooks();
    boolean that_present_books = true && that.isSetBooks();
    if (this_present_books || that_present_books) {
      if (!(this_present_books && that_present_books))
        return false;
      if (!this.books.equals(that.books))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Contact other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBirthday()).compareTo(other.isSetBirthday());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBirthday()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.birthday, other.birthday);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPhoneNo()).compareTo(other.isSetPhoneNo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPhoneNo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.phoneNo, other.phoneNo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIpAddress()).compareTo(other.isSetIpAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIpAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ipAddress, other.ipAddress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProps()).compareTo(other.isSetProps());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProps()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.props, other.props);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSalary()).compareTo(other.isSetSalary());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSalary()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.salary, other.salary);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBooks()).compareTo(other.isSetBooks());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBooks()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.books, other.books);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Contact(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("birthday:");
    sb.append(this.birthday);
    first = false;
    if (!first) sb.append(", ");
    sb.append("phoneNo:");
    if (this.phoneNo == null) {
      sb.append("null");
    } else {
      sb.append(this.phoneNo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ipAddress:");
    if (this.ipAddress == null) {
      sb.append("null");
    } else {
      sb.append(this.ipAddress);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("props:");
    if (this.props == null) {
      sb.append("null");
    } else {
      sb.append(this.props);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("salary:");
    sb.append(this.salary);
    first = false;
    if (!first) sb.append(", ");
    sb.append("books:");
    if (this.books == null) {
      sb.append("null");
    } else {
      sb.append(this.books);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ContactStandardSchemeFactory implements SchemeFactory {
    public ContactStandardScheme getScheme() {
      return new ContactStandardScheme();
    }
  }

  private static class ContactStandardScheme extends StandardScheme<Contact> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Contact struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BIRTHDAY
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.birthday = iprot.readI64();
              struct.setBirthdayIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PHONE_NO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.phoneNo = iprot.readString();
              struct.setPhoneNoIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // IP_ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ipAddress = iprot.readString();
              struct.setIpAddressIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PROPS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.props = new HashMap<String,String>(2*_map0.size);
                for (int _i1 = 0; _i1 < _map0.size; ++_i1)
                {
                  String _key2;
                  String _val3;
                  _key2 = iprot.readString();
                  _val3 = iprot.readString();
                  struct.props.put(_key2, _val3);
                }
                iprot.readMapEnd();
              }
              struct.setPropsIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // SALARY
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.salary = iprot.readDouble();
              struct.setSalaryIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // BOOKS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set4 = iprot.readSetBegin();
                struct.books = new HashSet<Book>(2*_set4.size);
                for (int _i5 = 0; _i5 < _set4.size; ++_i5)
                {
                  Book _elem6;
                  _elem6 = new Book();
                  _elem6.read(iprot);
                  struct.books.add(_elem6);
                }
                iprot.readSetEnd();
              }
              struct.setBooksIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Contact struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BIRTHDAY_FIELD_DESC);
      oprot.writeI64(struct.birthday);
      oprot.writeFieldEnd();
      if (struct.phoneNo != null) {
        oprot.writeFieldBegin(PHONE_NO_FIELD_DESC);
        oprot.writeString(struct.phoneNo);
        oprot.writeFieldEnd();
      }
      if (struct.ipAddress != null) {
        oprot.writeFieldBegin(IP_ADDRESS_FIELD_DESC);
        oprot.writeString(struct.ipAddress);
        oprot.writeFieldEnd();
      }
      if (struct.props != null) {
        oprot.writeFieldBegin(PROPS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.props.size()));
          for (Map.Entry<String, String> _iter7 : struct.props.entrySet())
          {
            oprot.writeString(_iter7.getKey());
            oprot.writeString(_iter7.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SALARY_FIELD_DESC);
      oprot.writeDouble(struct.salary);
      oprot.writeFieldEnd();
      if (struct.books != null) {
        oprot.writeFieldBegin(BOOKS_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, struct.books.size()));
          for (Book _iter8 : struct.books)
          {
            _iter8.write(oprot);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ContactTupleSchemeFactory implements SchemeFactory {
    public ContactTupleScheme getScheme() {
      return new ContactTupleScheme();
    }
  }

  private static class ContactTupleScheme extends TupleScheme<Contact> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Contact struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetBirthday()) {
        optionals.set(2);
      }
      if (struct.isSetPhoneNo()) {
        optionals.set(3);
      }
      if (struct.isSetIpAddress()) {
        optionals.set(4);
      }
      if (struct.isSetProps()) {
        optionals.set(5);
      }
      if (struct.isSetSalary()) {
        optionals.set(6);
      }
      if (struct.isSetBooks()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetBirthday()) {
        oprot.writeI64(struct.birthday);
      }
      if (struct.isSetPhoneNo()) {
        oprot.writeString(struct.phoneNo);
      }
      if (struct.isSetIpAddress()) {
        oprot.writeString(struct.ipAddress);
      }
      if (struct.isSetProps()) {
        {
          oprot.writeI32(struct.props.size());
          for (Map.Entry<String, String> _iter9 : struct.props.entrySet())
          {
            oprot.writeString(_iter9.getKey());
            oprot.writeString(_iter9.getValue());
          }
        }
      }
      if (struct.isSetSalary()) {
        oprot.writeDouble(struct.salary);
      }
      if (struct.isSetBooks()) {
        {
          oprot.writeI32(struct.books.size());
          for (Book _iter10 : struct.books)
          {
            _iter10.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Contact struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.birthday = iprot.readI64();
        struct.setBirthdayIsSet(true);
      }
      if (incoming.get(3)) {
        struct.phoneNo = iprot.readString();
        struct.setPhoneNoIsSet(true);
      }
      if (incoming.get(4)) {
        struct.ipAddress = iprot.readString();
        struct.setIpAddressIsSet(true);
      }
      if (incoming.get(5)) {
        {
          org.apache.thrift.protocol.TMap _map11 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.props = new HashMap<String,String>(2*_map11.size);
          for (int _i12 = 0; _i12 < _map11.size; ++_i12)
          {
            String _key13;
            String _val14;
            _key13 = iprot.readString();
            _val14 = iprot.readString();
            struct.props.put(_key13, _val14);
          }
        }
        struct.setPropsIsSet(true);
      }
      if (incoming.get(6)) {
        struct.salary = iprot.readDouble();
        struct.setSalaryIsSet(true);
      }
      if (incoming.get(7)) {
        {
          org.apache.thrift.protocol.TSet _set15 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.books = new HashSet<Book>(2*_set15.size);
          for (int _i16 = 0; _i16 < _set15.size; ++_i16)
          {
            Book _elem17;
            _elem17 = new Book();
            _elem17.read(iprot);
            struct.books.add(_elem17);
          }
        }
        struct.setBooksIsSet(true);
      }
    }
  }

}

