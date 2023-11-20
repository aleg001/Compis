
class Main inherits IO {
    main() : SELF_TYPE {
	{
	    out_string((new Object).type_name().substr(1,4));
	    out_string("\n");
	    out_string((isvoid self).type_name().substr(0,2));
	}
    };
};
