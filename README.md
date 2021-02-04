![Develop Status][workflow-badge-develop]
![Main Status][workflow-badge-main]
![Version][version-badge] 

# base-lib
**base-lib** is a base library for a number of libraries and applications under the uk.co.lukestevens group. It contains interfaces, annotations, and utilities for use by other
libraries.

## Installation

Install the latest version of base-lib using Maven:

```	
<dependency>
	<groupId>uk.co.lukestevens</groupId>
	<artifactId>base-lib</artifactId>
	<version>2.0.0</version>
</dependency>
```

### Github Packages Authentication
Currently public packages on Github require authentication to be installed by Maven. Add the following repository to your project's `.m2/settings.xml`

```
<repository>
	<id>github-lukecmstevens</id>
	<name>GitHub lukecmstevens Apache Maven Packages</name>
	<url>https://maven.pkg.github.com/lukecmstevens/packages</url>
	<snapshots><enabled>true</enabled></snapshots>
</repository>
```

For more information see here: [Authenticating with Github packages][gh-package-auth]

## Usage
base-lib provides a range of utility classes, including those for mocking dates and environment variables.

### Dates
The `Dates` class provides wrapped methods to allow timestamp based instantiation to be mocked.

```
new Date(); // instead of this
Dates.now(); // use this

Calendar.getInstance(); // instead of this
Dates.getCalendar(); // use this

System.currentTimeMillis(); // instead of this
Dates.millis(); // use this
```

This will enable you to easy mock the timestamp of created dates in tests with

```
DateMocker.setCurrentDate(date);
DateMocker.removeMockedDate();
```

### Environment Variables
The `EnvironmentVariables` class provides wrapped methods to allow environment variables to be mocked

```
System.getenv(); // instead of this
EnvironmentVariables.get(); // use this

System.getenv(string); // instead of this
EnvironmentVariables.get(string); // use this
```

This will enable you to easily build a set of mocked environment variables to test applications
dependent on them. For example:

```
EnvironmentVariableMocker.build()
		.with(properties)
		.with(key, value)
		.mock();
EnvironmentVariableMocker.clear();
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

New features, fixes, and bugs should be branched off of develop.

Please make sure to update tests as appropriate.

## License
[MIT][mit-license]

[gh-package-auth]: https://docs.github.com/en/free-pro-team@latest/packages/guides/configuring-apache-maven-for-use-with-github-packages#authenticating-to-github-packages
[workflow-badge-develop]: https://github.com/lukecmstevens/base-lib/workflows/Publish%20Develop/badge.svg?branch=develop
[workflow-badge-main]: https://github.com/lukecmstevens/base-lib/workflows/Release%20Main/badge.svg?branch=main
[version-badge]: https://img.shields.io/github/v/release/lukecmstevens/base-lib
[mit-license]: https://choosealicense.com/licenses/mit/

