select result.*, rownum
    from (select * from board_file order by num desc) result
where rownum between 1 and 2;