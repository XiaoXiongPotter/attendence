package com.hangsheng.kaoqin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStaff is a Querydsl query type for Staff
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaff extends EntityPathBase<Staff> {

    private static final long serialVersionUID = -703174749L;

    public static final QStaff staff = new QStaff("staff");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mac = createString("mac");

    public final StringPath mobile = createString("mobile");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QStaff(String variable) {
        super(Staff.class, forVariable(variable));
    }

    public QStaff(Path<? extends Staff> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStaff(PathMetadata metadata) {
        super(Staff.class, metadata);
    }

}

