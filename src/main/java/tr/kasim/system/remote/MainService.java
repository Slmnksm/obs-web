/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.kasim.system.remote;

import java.util.List;
import org.apache.log4j.Logger;
import tr.kasim.system.app.Application;
import tr.kasim.system.db.Session;
import tr.kasim.system.model.Student;
import tr.kasim.system.model.Lecture;
import tr.kasim.system.model.Note;
import tr.kasim.system.model.Teacher;
import tr.kasim.system.model.User;
import tr.kasim.system.services.LectureService;
import tr.kasim.system.services.NoteService;
import tr.kasim.system.services.StudentService;
import tr.kasim.system.services.TeacherService;
import tr.kasim.system.services.UserService;

/**
 *
 * @author S.KasımYurtaslan
 */
public class MainService {

    Logger log = Logger.getLogger(MainService.class);

    public Student saveStudent(Student student)
            throws Exception {

        Session session = newSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addStudent][Start] " + student);
            }

            Student savedStudent = ((StudentService) getService("studentService")).save(session, student);

            session.commit();
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addStudent][Complete] " + savedStudent);
            }
            return savedStudent;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addStudent][Error] " + student + ", msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Student> getStudents()
            throws Exception {
        List<Student> result;
        Session session = newSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getStudents][Start] ");
            }

            result = ((StudentService) getService("studentService")).getAll(session);

            if (log.isDebugEnabled()) {
                log.debug("[MainService][getStudents][Complete] size:" + result.size());
            }
            return result;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getStudents][Error] msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Lecture addLecture(Lecture lecture)
            throws Exception {

        Session session = newSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addLecture][Start] " + lecture);
            }

            Lecture savedlecture = ((LectureService) getService("lectureService")).save(session, lecture);

            session.commit();
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addLecture][Complete] " + savedlecture);
            }
            return savedlecture;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addLecture][Error] " + lecture + ", msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Lecture> getLectures()
            throws Exception {
        List<Lecture> result;
        Session session = newSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getLectures][Start] ");
            }

            result = ((LectureService) getService("lectureService")).getAll(session);

            if (log.isDebugEnabled()) {
                log.debug("[MainService][getLectures][Complete] size:" + result.size());
            }
            return result;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getLectures][Error] msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Lecture getLectureByCode(String code)
            throws Exception {
        Lecture result;
        Session session = newSession();

        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getLectureByCode][Start] code:" + code);
            }

            result = ((LectureService) getService("lectureService")).getByCode(session, code);

            if (log.isDebugEnabled()) {
                log.debug("[MainService][getLectureByCode][Complete] code:" + code + " ,result:" + result);
            }
            return result;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getLectureByCode][Error]  code:" + code + " msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Object getById(Integer id, Class type)
            throws Exception {
        Object result = null;
        Session session = newSession();

        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getById][Start] " + id);
            }
            if (type == Lecture.class) {
                result = ((LectureService) getService("lectureService")).getById(session, id);
            } else if (type == Student.class) {
                result = ((StudentService) getService("studentService")).getById(session, id);
            }

            if (log.isDebugEnabled()) {
                log.debug("[MainService][getById][Complete] " + id + " ,result:" + result);
            }
            return result;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getById][Error]  " + id + " msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Student getStudentNumber(String studentNumber)
            throws Exception {
        Student result;
        Session session = newSession();

        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getStudentNumber][Start] studentNumber:" + studentNumber);
            }

            result = ((StudentService) getService("studentService")).getStudentNumber(session, studentNumber);

            if (log.isDebugEnabled()) {
                log.debug("[MainService][getStudentNumber][Complete] studentNumber:" + studentNumber + " ,result:" + result);
            }
            return result;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getStudentNumber][Error]  studentNumber:" + studentNumber + " msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Note addNote(Note note)
            throws Exception {

        Session session = newSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addNote][Start] " + note);
            }

            Note savedNote = ((NoteService) getService("noteService")).save(session, note);

            session.commit();
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addNote][Complete] " + savedNote);
            }
            return savedNote;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][addNote][Error] " + note + ", msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Note getNoteByStudentAndLectureId(String studentNumber, String lectureCode)
            throws Exception {
        Note result;
        Session session = newSession();

        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getNoteById][Start] stdNumber:" + studentNumber + ",lectureCode:" + lectureCode);
            }

            result = ((NoteService) getService("noteService")).getNoteByStudentAndLectureId(session, studentNumber, lectureCode);

            if (log.isDebugEnabled()) {
                log.debug("[MainService][getNoteById][Complete] stdNumber:" + studentNumber + ",lectureCode:" + lectureCode + " ,result:" + result);
            }
            return result;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][getNoteById][Error]  stdNumber:" + studentNumber + ",lectureCode:" + lectureCode + " msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public User saveUser(User user)
            throws Exception {

        Session session = newSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][saveUser][Start] " + user);
            }

            User savedUser = ((UserService) getService("userService")).save(session, user);

            session.commit();
            if (log.isDebugEnabled()) {
                log.debug("[MainService][saveUser][Complete] " + savedUser);
            }
            return savedUser;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][saveUser][Error] " + user + ", msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Teacher saveTeacher(Teacher teacher)
            throws Exception {

        Session session = newSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][saveTeacher][Start] " + teacher);
            }

            Teacher savedTeacher = ((TeacherService) getService("teacherService")).save(session, teacher);

            session.commit();
            if (log.isDebugEnabled()) {
                log.debug("[MainService][saveTeacher][Complete] " + savedTeacher);
            }
            return savedTeacher;
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("[MainService][saveTeacher][Error] " + teacher + ", msg:" + e.getMessage(), e);
            }
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    private Session newSession() {
        Session session = new Session(Application.getApp().getEntityManagerFactory().createEntityManager());
        return session;

    }

    public Object getService(String serviceName) {
        return Application.getApp().getSpring().getBean(serviceName);
    }

}
