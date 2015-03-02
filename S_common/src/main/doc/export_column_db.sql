SELECT ut.TABLE_NAME,
       ut.COLUMN_NAME,
       '',
       UT.DATA_TYPE || CASE ut.DATA_TYPE
         WHEN 'NUMBER' THEN
          CASE ut.DATA_SCALE
            WHEN 0 THEN
             '(' || ut.DATA_PRECISION || ')'
            ELSE
             '(' || ut.DATA_PRECISION || ',' || ut.DATA_SCALE || ')'
          END
         WHEN 'DATE' THEN
          NULL
         WHEN 'CHAR' THEN
          NULL
         ELSE
          '(' || UT.DATA_LENGTH || ')'
       END AS COL_TYPE
  FROM user_tab_columns ut;
