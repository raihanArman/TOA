message "Thanks @#{github.pr_author}"

if github.pr_body.length == 0
    fail "Please provide a summary in the Pull Request description"
end

if git.lines_of_code > 500
    warn "Please consider breaking up this pull request"
end

if github.pr_labels.empty?
    warn "Please add labels to this PR"
end

if git.deletions > git.insertions
    message "Code Cleanup!"
end

# if !git.modified_files.include?("stream-history.md")
#     fail "Please update stream-history.md with relevant information"
# end

# Notify of outdated dependencies
dependencyReportsFile = "app/build/dependencyUpdates/report.txt"
dependencyUpdatesHeader = "The following dependencieshave later milestone versions"

hasDependencyUpdatesHeader = File.readlines(dependencyReportsFile).grap(/#{dependencyUpdatesHeader}/).any?

if hasDependencyUpdatesHeader
    file = File.open(dependencyUpdatesHeader, "rb").read
    index = file.index(dependencyUpdatesHeader)
    message = file.slice(index..-1)
end