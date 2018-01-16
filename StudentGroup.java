
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StudentGroup implements GroupOperationService {

	private Student[] students;

	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		if (students == null) {
			throw new IllegalArgumentException();
		} else {
			this.students = students;
		}
	}

	@Override
	public Student getStudent(int index) {

		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			return this.students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index) {
		if (student == null || index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();

		} else {
			this.students[index] = student;
		}

	}

	@Override
	public void addFirst(Student student) {

		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			if (this.students[0] != null) {
				Student[] students = new Student[this.students.length + 1];
				students[0] = student;
				for (int i = 1; i < students.length; i++) {
					students[i] = this.students[i - 1];
				}

				this.students = students;

			} else {
				this.students[0] = student;
			}

		}
	}

	@Override
	public void addLast(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			if (this.students[this.students.length - 1] != null) {
				Student[] students = new Student[this.students.length + 1];
				students[students.length - 1] = student;
				for (int i = students.length - 2; i >= 0; i--) {
					students[i] = this.students[i];
				}

				this.students = students;

			} else {
				this.students[this.students.length - 1] = student;

			}
		}

	}

	@Override
	public void add(Student student, int index) {
		if (student == null || index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();

		} else {
			if (this.students[index] == null) {
				this.students[index] = student;
			} else {
				Student[] students = new Student[this.students.length + 1];
				students[index] = student;

				for (int i = 0; i < index; i++) {
					students[i] = this.students[i];
				}

				for (int i = index + 1; i < students.length; i++) {
					students[i] = this.students[i - 1];
				}
				this.students = students;

			}

		}
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();

		} else {
			Student[] students = new Student[this.students.length - 1];
			for (int i = 0; i < index; i++) {
				students[i] = this.students[i];
			}

			for (int i = index + 1; i < this.students.length; i++) {
				students[i - 1] = this.students[i];
			}
			this.students = students;

		}

	}

	@Override
	public void remove(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			int k;
			for (k = 0; k < this.students.length; k++) {
				if (this.students[k] == student) {
					break;
				}
			}

			Student[] students = new Student[this.students.length - 1];

			for (int i = 0; i < k; i++) {
				students[i] = this.students[i];
			}

			for (int i = k + 1; i < this.students.length; i++) {
				students[i - 1] = this.students[i];
			}
			this.students = students;
		}

	}

	@Override
	public void removeFromIndex(int index) { // удаление, включая параметр
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();

		} else if (index == 0) {
			Student[] students = new Student[0];
			this.students = students;

		} else {

			Student[] students = new Student[index];
			for (int i = 0; i < students.length; i++) {
				students[i] = this.students[i];
			}
			this.students = students;

		}

	}

	@Override
	public void removeFromElement(Student student) { // удаление, включая параметр
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			int j;
			for (j = 0; j < this.students.length; j++) {
				if (this.students[j] == student) {
					break;
				}
			}

			this.removeFromIndex(j);

		}

	}

	@Override
	public void removeToIndex(int index) { // удаление,  НЕ включая параметр

		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();

		} /*else if (index == this.students.length - 1) {
			for (int i = 0; i < this.students.length; i++) {
				this.students[i] = null;
			}
		}*/ else {
			Student[] students = new Student[this.students.length - index /* -1 */ ];
			for (int i = 0; i < students.length; i++) {
				students[i] = this.students[i + index /* + */];
			}
			this.students = students;

		}

	}

	@Override
	public void removeToElement(Student student) { // удаление, НЕ включая параметр
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			int j;
			for (j = 0; j < this.students.length; j++) {
				if (this.students[j] == student) {
					break;
				}
			}

			this.removeToIndex(j);
		}

	}

	@Override
	public void bubbleSort() {

		int l = this.students.length;
		for (int i = 0; i < l; i++) {
			if (this.students[i] != null) {
			} else {
				for (int j = i + 1; j < l; j++) {
					if (this.students[j] != null) {
						this.students[i] = this.students[j];
						this.students[j] = null;
						break;
					}

				}

			}

		}

		int countnull = 0;
		for (int i = 0; i < l; i++) {
			if (this.students[i] == null) {
				countnull++;
			}
		}
		Student[] students = new Student[this.students.length - countnull];
		for (int j = 0; j < students.length; j++) {
			students[j] = this.students[j];
		}

		Student a;
		for (int k = 1; k < students.length; k++) {
			for (int i = 0; i < students.length - 1; i++) {
				int result = students[i].getFullName().compareTo(students[i + 1].getFullName());
				if (result > 0) {
					a = students[i];
					students[i] = students[i + 1];
					students[i + 1] = a;

				}
			}

		}
		this.students = students;

	}

	@Override
	public Student[] getByBirthDate(Date date) {

		if (date == null) {
			throw new IllegalArgumentException();
		} else {
			int count = 0;
			for (int i = 0; i < this.students.length; i++) {
				if (this.students[i] != null && this.students[i].getBirthDate().equals(date)) {
					count++;
				}
			}
			if (count != 0) {
				Student[] students = new Student[count];
				int k = 0;
				for (int i = 0; i < this.students.length; i++) {
					if (this.students[i] != null && this.students[i].getBirthDate().equals(date)) {
						students[k] = this.students[i];
						k++;
					}
				}
				return students;

			} else {
				Student[] students = new Student[0];
				return students;
			}

		}

	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if (firstDate == null || lastDate == null) {
			throw new IllegalArgumentException();
		} else {
			int count = 0;
			for (int i = 0; i < this.students.length; i++) {
				if (this.students[i] != null && this.students[i].getBirthDate().after(firstDate)
						&& this.students[i].getBirthDate().before(lastDate)) {
					count++;

				}

			}
			if (count != 0) {
				Student[] students = new Student[count];
				int k = 0;
				for (int i = 0; i < this.students.length; i++) {
					if (this.students[i] != null && this.students[i].getBirthDate().after(firstDate)
							&& this.students[i].getBirthDate().before(lastDate)) {
						students[k] = this.students[i];
						k++;
					}
				}
				return students;

			} else {
				Student[] students = new Student[0];
				return students;
			}

		}

	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if (date == null) {
			throw new IllegalArgumentException();
		} else {
			Calendar calFrom = Calendar.getInstance();
			calFrom.setTime(date);
			calFrom.add(Calendar.DATE, -days);
			Calendar calTo = Calendar.getInstance();
			calTo.setTime(date);
			calTo.add(Calendar.DATE, days);
			int count = 0;

			for (int i = 0; i < this.students.length; i++) {
				if (this.students[i] != null && this.students[i].getBirthDate().after(calFrom.getTime())
						&& this.students[i].getBirthDate().before(calTo.getTime())) {
					count++;

				}

			}

			if (count != 0) {
				Student[] students = new Student[count];
				int k = 0;
				for (int i = 0; i < this.students.length; i++) {
					if (this.students[i] != null && this.students[i].getBirthDate().after(calFrom.getTime())
							&& this.students[i].getBirthDate().before(calTo.getTime())) {
						students[k] = this.students[i];
						k++;

					}
				}
				return students;
			} else {
				Student[] students = new Student[0];
				return students;
			}

		}

	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if (indexOfStudent < 0) {
			throw new IllegalArgumentException();
		} else {
			Calendar c1 = Calendar.getInstance();
			int j = 10000;
			for (int i = 0; i < this.students.length; i++) {
				if (this.students[i].getId() == indexOfStudent) {
					j = i;
				}
			}
			if (j == 10000) {
				throw new IllegalArgumentException();
			} else {
				Calendar c2 = Calendar.getInstance();
				c2.setTime(this.students[j].getBirthDate());
				int age = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
				int finalAge = c1.get(Calendar.DAY_OF_YEAR) - c2.get(Calendar.DAY_OF_YEAR);
				if (finalAge >= 0) {
					return age;
				}
				return age - 1;
			}
		}

	}

	@Override
	public Student[] getStudentsByAge(int age) {
		if (age <= 0) {
			throw new IllegalArgumentException();
		} else {
			int count = 0;
			for (int i = 0; i < this.students.length; i++) {
				if (this.students[i] != null && this.getCurrentAgeByDate(this.students[i].getId()) == age) {
					count++;
				}
			}

			if (count != 0) {
				Student[] students = new Student[count];
				int k = 0;
				for (int i = 0; i < this.students.length; i++) {
					if (this.students[i] != null && this.getCurrentAgeByDate(this.students[i].getId()) == age) {
						students[k] = this.students[i];
						k++;
					}
				}
				return students;
			} else {
				Student[] students = new Student[0];
				return students;
			}

		}

	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double max = 0;
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] != null && max < this.students[i].getAvgMark()) {
				max = this.students[i].getAvgMark();
			}
		}
		int count = 0;
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] != null && this.students[i].getAvgMark() == max) {
				count++;
			}

		}
		Student[] students = new Student[count];
		int k = 0;
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] != null && this.students[i].getAvgMark() == max) {
				students[k] = this.students[i];
				k++;
			}
		}

		return students;
	}

	@Override
	public Student getNextStudent(Student student) {
		Student nextSt = null;
		if (student == null) {
			throw new IllegalArgumentException();
		} else {

			for (int i = 0; i < this.students.length; i++) {
				if (student == this.students[i]) {
					if (i != this.students.length - 1) {
						nextSt = this.students[i + 1];
					} else {
						throw new IllegalArgumentException();
					}

				}
			}
		}

		return nextSt;
	}
}
