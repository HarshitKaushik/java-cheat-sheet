# Set the version of Jabba version manager you want to install.

```bash

export JABBA_VERSION=0.11.2

```

```bash
Output-

.sh
Installing v0.11.2...

Skipped update of /Users/harshitkaushik/.bashrc (source string already present)
Skipped update of /Users/harshitkaushik/.bash_profile (source string already present)
Skipped update of /Users/harshitkaushik/.zshrc (source string already present)

Installation completed
(if you have any problems please report them at https://github.com/shyiko/jabba/issues)
```

# Usage

```bash
Java Version Manager (https://github.com/shyiko/jabba).

Usage:
  jabba [flags]
  jabba [command]

Available Commands:
  install     Download and install JDK
  uninstall   Uninstall JDK
  link        Resolve or update a link
  unlink      Delete a link
  use         Modify PATH & JAVA_HOME to use specific JDK
  current     Display currently 'use'ed version
  ls          List installed versions
  ls-remote   List remote versions available for install
  deactivate  Undo effects of `jabba` on current shell
  alias       Resolve or update an alias
  unalias     Delete an alias
  which       Display path to installed JDK

Flags:
  -h, --help      help for jabba
      --version   version of jabba

Use "jabba [command] --help" for more information about a command.
```

