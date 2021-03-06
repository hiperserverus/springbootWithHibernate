package com.juniorgonzalez.spring.dao;

import com.juniorgonzalez.spring.model.Course;

import java.util.List;

public class CourseDaoImpl extends AbstractSession implements CourseDao{
    @Override
    public void saveCourse(Course course) {

       getSession().persist(course);

    }

    @Override
    public void deleteCourseById(Long idCourse) {

        Course course = findById(idCourse);

        if ((course != null)) {
            getSession().delete(course);
        }
    }

    @Override
    public void updateCourse(Course course) {

        getSession().update(course);

    }

    @Override
    public List<Course> findAllCourses() {

        return getSession().createQuery("from Course").list();
    }

    @Override
    public Course findById(Long idCourse) {

        return (Course) getSession().get(Course.class, idCourse);
    }

    @Override
    public Course findByName(String name) {

        return (Course) getSession().createQuery(
                "from Course where name = :name")
                .setParameter("name", name).uniqueResult();


    }

    @Override
    public List<Course> findByIdTeacher(Long idTeacher) {

        return (List<Course>) getSession().createQuery(
                "from Course c join c.teacher t where t.idTeacher = :idTeacher")
                .setParameter("idTeacher", idTeacher).list();
    }
}
