package com.github.paint.formats;

import com.github.paint.CustomLine;

import java.util.List;

public interface IBaseFormat{

    void toFormat (List <CustomLine> lines, String file);

    List <CustomLine> fromFormat (String file);

}
